package com.lotushint.crowd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lotushint.crowd.entity.Role;
import com.lotushint.crowd.mapper.RoleMapper;
import com.lotushint.crowd.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/24 19:39
 * @package com.lotushint.crowd.service.impl
 * @description
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {
        //1.开启分页功能
        PageHelper.startPage(pageNum, pageSize);

        //2.执行查询
        List<Role> roleList = roleMapper.selectRoleByKeyword(keyword);
        //3.封装为PageInfo返回
        return new PageInfo<>(roleList);
    }
}
