package com.lotushint.dao;

import com.lotushint.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountDao {

    @Insert("insert into user(name)values(#{name})")
    void save(Account account);

    @Delete("delete from user where id = #{id} ")
    void delete(Integer id);

    @Update("update user set name = #{name} where id = #{id} ")
    void update(Account account);

    @Select("select id,name from user")
    List<Account> findAll();

    @Select("select id,name from user where id = #{id} ")
    Account findById(Integer id);
}