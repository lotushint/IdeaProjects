package com.lotushint.boot.mapper;

import com.lotushint.boot.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    /**
     * 以注解的方式实现ssm整合
     */
    @Select("SELECT * FROM student")
    List<Student> getAll();

    @Select("SELECT * FROM student where id=#{id}")
    Student getById(@Param("id") int id);

}
