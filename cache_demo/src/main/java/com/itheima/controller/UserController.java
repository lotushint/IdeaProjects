package com.itheima.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.entity.User;
import com.itheima.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private UserService userService;

    /**
     * TODO CachePut:将方法的返回值放入缓存
     * value: 缓存的名称，每个缓存名称下面可以有多个 key（可以认为是一类缓存）
     * key: 缓存的 key（源码注释中有说明如何写）
     *
     * @param user
     * @return
     */
    @CachePut(value = "userCache", key = "#result.id")
    @PostMapping
    public User save(User user) {
        userService.save(user);
        return user;
    }

    /**
     * TODO CacheEvict: 将一条或多条数据从缓存中删除，key 可以有多种写法
     *
     * @param id
     */
    @CacheEvict(value = "userCache", key = "#p0")
//    @CacheEvict(value = "userCache", key = "#root.args[0]")
//    @CacheEvict(value = "userCache", key = "#id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.removeById(id);
    }

    @CacheEvict(value = "userCache", key = "#p0.id")
    @PutMapping
    public User update(User user) {
        userService.updateById(user);
        return user;
    }

    /**
     * TODO Cacheable: 在方法执行前 Spring 先查看缓存中是否有数据，如果有数据，则直接返回缓存数据；
     *            若没有数据，调用方法并将方法返回值放到缓存中
     * value: 缓存的名称，每个缓存名称下面可以有多个 key（可以认为是一类缓存）
     * key: 缓存的 key（源码注释中有说明如何写）
     * condition: 条件，满足条件时才缓存数据
     * unless: 满足条件则不缓存
     * @param id
     * @return
     */
    @Cacheable(value = "userCache", key = "#id", unless = "#result == null ")
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return user;
    }

    @Cacheable(value = "userCache", key = "#user.id + '_' + #user.name")
    @GetMapping("/list")
    public List<User> list(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(user.getId() != null, User::getId, user.getId());
        queryWrapper.eq(user.getName() != null, User::getName, user.getName());
        List<User> list = userService.list(queryWrapper);
        return list;
    }
}
