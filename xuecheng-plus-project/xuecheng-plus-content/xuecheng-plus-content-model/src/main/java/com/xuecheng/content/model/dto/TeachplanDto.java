package com.xuecheng.content.model.dto;

import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.model.po.TeachplanMedia;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/6/24 18:25
 * @package com.xuecheng.content.model.dto
 * @description 课程计划信息模型类
 */
@Data
@ToString
public class TeachplanDto extends Teachplan {
    /**
     * 与媒资管理的信息
     */
    private TeachplanMedia teachplanMedia;

    /**
     * 小章节 list
     */
    private List<TeachplanDto> teachPlanTreeNodes;
}
