package com.xuecheng.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.model.po.CourseCategory;

import java.util.List;

/**
 * <p>
 * 课程分类 Mapper 接口
 * </p>
 *
 * @author lotushint
 */
public interface CourseCategoryMapper extends BaseMapper<CourseCategory> {

    /**
     * 使用递归查询分类
     * @param id
     */
    List<CourseCategoryTreeDto> selectTreeNodes(String id);
}
