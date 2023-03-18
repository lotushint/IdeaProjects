package com.lotushint.dao;

import com.lotushint.entity.Base;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BaseDao {

    //，
    @Select("select id,idCard,name,age,gender,address,phone from base where id =#{id}")
    public Base findById(int id);
    @Delete("delete from base where id=#{id}")
    public void  delete(int id);
    @Insert("insert into base(idCard,name,age,gender,address,phone ) values(#{idCard},#{name},#{age},#{gender},#{address},#{phone})")
    public void add(Base base);

    @Select("select id,idCard,name,age,gender,address,phone from base where idCard = #{idCard}")
    public Base findByIdCard(String idCard);

    @Update("update base set address=#{address},phone=#{phone} where id=#{id}")
    public void update(Base base);

}
