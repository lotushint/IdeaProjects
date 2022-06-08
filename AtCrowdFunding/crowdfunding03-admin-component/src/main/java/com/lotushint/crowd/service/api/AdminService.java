package com.lotushint.crowd.service.api;

import com.github.pagehelper.PageInfo;
import com.lotushint.crowd.entity.Admin;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/11 17:32
 * @package com.lotushint.crowd.service.api
 * @description
 */
public interface AdminService {
    void saveAdmin(Admin admin);

    List<Admin> getAll();

    Admin getAdminByLoginAcct(String loginAcct, String userPswd);

    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    void remove(Integer adminId);

    Admin getAdminById(Integer adminId);

    void update(Admin admin);
}
