package com.lotushint.boot.dao.impl;

import com.lotushint.boot.dao.IUserDao;
import com.lotushint.boot.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 9:51
 * @package com.lotushint.boot.dao.impl
 * @description
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Users user) {
        return jdbcTemplate.update("insert into users(username, password) values(?, ?)",
                user.getUsername(),user.getPassword());
    }

    @Override
    public int update(Users user) {
        return jdbcTemplate.update("UPDATE  users SET username=? ,password=? WHERE id=?",
                user.getUsername(),user.getPassword(),user.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from users where id=?",id);
    }

    @Override
    public Users findUserById(int id) {
        // BeanPropertyRowMapper 使获取的 List 结果列表的数据库字段和实体类自动对应
        List<Users> list = jdbcTemplate.query("select * from users where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Users.class));
        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Users> findUserList() {
        // 使用Spring的JdbcTemplate查询数据库，获取List结果列表，数据库表字段和实体类自动对应，可以使用BeanPropertyRowMapper
        List<Users> list = jdbcTemplate.query("select * from users", new Object[]{}, new BeanPropertyRowMapper(Users.class));
        return list.size()>0?list:null;
    }

}
