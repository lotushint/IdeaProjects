package com.lotushint.boot.mapper;

import com.lotushint.boot.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 14:27
 * @package com.lotushint.boot.mapper
 * @description 在Mybatis的Mapper接口中,增删改查都有对应的注解.@Insert,@Select,@Delete,@Update
 */
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User queryUserById(@Param(value = "id") int id);

    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    void insertUser(User user);

    @Update("UPDATE user SET sex=#{sex} WHERE username=#{username}")
    void updateUser(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void deleteById(@Param("id") int id);
}
