package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/13 16:38
 * @package com.itheima.reggie.mapper
 * @description
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
