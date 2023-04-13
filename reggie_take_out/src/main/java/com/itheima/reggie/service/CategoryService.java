package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.mapper.CategoryMapper;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/13 16:39
 * @package com.itheima.reggie.service
 * @description
 */
public interface CategoryService extends IService<Category> {
    void remove(Long id);
}
