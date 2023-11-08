package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/6/24 19:26
 * @package com.xuecheng.content.service
 * @description 课程计划管理相关接口
 */
public interface TeachplanService {
    /**
     * 根据课程 id 查询课程计划
     *
     * @param courseId 课程计划
     * @return
     */
    List<TeachplanDto> findTeachplanTree(Long courseId);

    /**
     * 新增/修改/保存课程计划
     *
     * @param teachplanDto
     */
    void saveTeachplan(SaveTeachplanDto teachplanDto);
}
