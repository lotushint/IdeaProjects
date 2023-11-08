package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/6/13 12:19
 * @package com.xuecheng.content.service
 * @description
 */
public interface CourseCategoryService {
    /**
     * 课程分类树型结构查询
     *
     * @param id
     * @return
     */
    List<CourseCategoryTreeDto> queryTreeNodes(String id);
}
