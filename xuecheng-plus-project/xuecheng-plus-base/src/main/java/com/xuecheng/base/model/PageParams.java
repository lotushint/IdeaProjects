package com.xuecheng.base.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/5/29 16:58
 * @package com.xuecheng.base.model
 * @description 分页查询分页参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParams {
    /**
     * 当前页码
     */
    @ApiModelProperty("页码")
    private Long pageNo = 1L;

    /**
     * 每页记录数默认值
     */
    @ApiModelProperty("每页记录数")
    private Long pageSize = 10L;
}
