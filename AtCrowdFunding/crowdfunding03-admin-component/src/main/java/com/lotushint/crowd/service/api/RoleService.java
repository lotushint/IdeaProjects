package com.lotushint.crowd.service.api;

import com.github.pagehelper.PageInfo;
import com.lotushint.crowd.entity.Role;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/24 19:38
 * @package com.lotushint.crowd.service.api
 * @description
 */
public interface RoleService {

    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword);

    void saveRole(Role role);

    void updateRole(Role role);

    void removeRole(List<Integer> roleIdList);
}
