package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.DishFlavor;
import com.itheima.reggie.mapper.DishMapper;
import com.itheima.reggie.service.DishFlavorService;
import com.itheima.reggie.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/13 18:09
 * @package com.itheima.reggie.service.impl
 * @description
 */
@Service
@Transactional
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    DishFlavorService dishFlavorService;

    /**
     * 新增菜品，同时保存对应的口味数据
     *
     * @param dishDto
     */
    @Override
    public void saveWithFlavor(DishDto dishDto) {
        //保存菜品的基本信息到菜品表
        super.save(dishDto);
        //获取菜品id
        Long dishId = dishDto.getId();
        //获取菜品口味
        List<DishFlavor> flavors = dishDto.getFlavors();

        //将每条 flavor 的 dishId 赋上值
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());

        //保存菜品口味数据到菜品口味表
        dishFlavorService.saveBatch(flavors);
    }

    @Override
    public DishDto getByIdWithFlavor(Long id) {
        //通过id查询菜品基本信息
        Dish dish = this.getById(id);

        //创建dto对象
        DishDto dishDto = new DishDto();

        //对象拷贝
        BeanUtils.copyProperties(dish, dishDto);

        //条件查询 flavor
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dish.getId());
        List<DishFlavor> list = dishFlavorService.list(queryWrapper);

        //将查询到的flavor赋值到dto对象中
        dishDto.setFlavors(list);

        return dishDto;
    }

    @Override
    public void updateWithFlavor(DishDto dishDto) {
        //根据id修改菜品的基本信息
        this.updateById(dishDto);

        //通过dish_id,删除菜品的flavor
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dishDto.getId());
        dishFlavorService.remove(queryWrapper);

        //获取前端提交的flavor数据
        List<DishFlavor> flavors = dishDto.getFlavors();

        //将每条flavor的dishId赋值
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());


        //将数据批量保存到dish_flavor数据库
        dishFlavorService.saveBatch(flavors);
    }
}
