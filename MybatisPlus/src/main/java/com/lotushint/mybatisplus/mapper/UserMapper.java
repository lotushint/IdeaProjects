package com.lotushint.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lotushint.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/6 20:07
 * @package com.lotushint.mybatisplus.mapper
 * @description
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据 id 查询用户信息为 map 集合
     *
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(Long id);

    /**
     * 根据年龄查询用户列表，分页显示
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位
     * @param age  年龄
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);
}
