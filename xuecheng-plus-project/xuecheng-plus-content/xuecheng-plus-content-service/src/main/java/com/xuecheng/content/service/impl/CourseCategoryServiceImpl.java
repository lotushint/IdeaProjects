package com.xuecheng.content.service.impl;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/6/13 12:21
 * @package com.xuecheng.content.service.impl
 * @description
 */
@Slf4j
@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;

    /**
     * TODO 课程分类树型结构查询
     *
     * @param id
     * @return
     */
    @Override
    public List<CourseCategoryTreeDto> queryTreeNodes(String id) {
        // 调用 mapper 递归查询出分类信息
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = courseCategoryMapper.selectTreeNodes(id);
        // 找到每个节点的子结点，最终封装成 List<CourseCategoryTreeDto>
        // 先将 list 转成 map ，key 就是结点的 id， value 就是 CourseCategoryTreeDto 对象，目的就是为了方便从 map 获取结点
        Map<String, CourseCategoryTreeDto> mapTemp =
                courseCategoryTreeDtos.stream()
                        .filter(item -> !id.equals(item.getId()))
                        .collect(Collectors.toMap(key -> key.getId(), value -> value, (key1, key2) -> key2));
        // 定义一个 list 作为最终返回的 list
        ArrayList<CourseCategoryTreeDto> courseCategoryList = new ArrayList<>();
        // 从头遍历 List<CourseCategoryTreeDto> ，一边遍历一边找子结点放在父结点的 childTreeNodes
        courseCategoryTreeDtos.stream().filter(item -> !id.equals(item.getId())).forEach(item -> {
            if (item.getParentid().equals(id)) {
                courseCategoryList.add(item);
            }
            // 找到结点的父结点
            CourseCategoryTreeDto courseCategoryParent = mapTemp.get(item.getParentid());
            if (courseCategoryParent != null) {
                if (courseCategoryParent.getChildrenTreeNodes() == null) {
                    // 存放子结点：如果该父结点的 ChildrenTreeNodes 属性为空要 new 一个集合
                    courseCategoryParent.setChildrenTreeNodes(new ArrayList<CourseCategoryTreeDto>());
                }
                // 到每个结点的子结点放在父结点的 childrenTreeNodes 属性中
                courseCategoryParent.getChildrenTreeNodes().add(item);
            }
        });
        return courseCategoryList;
    }
}
