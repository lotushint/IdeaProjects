package com.xuecheng.content.model.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/5/29 17:09
 * @package com.xuecheng.content.model.dto
 * @description 课程查询条件模型类
 */
@Data
@ToString
public class QueryCourseParamsDto {
    /**
     * 审核状态
     */
    private String auditStatus;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 发布状态
     */
    private String publishStatus;

}

