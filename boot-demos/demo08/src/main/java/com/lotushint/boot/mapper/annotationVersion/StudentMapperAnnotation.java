package com.lotushint.boot.mapper.annotationVersion;

import com.lotushint.boot.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/14 10:48
 * @package com.lotushint.boot.mapper.annotationVersion
 * @description 注解方式ssm整合
 */
public interface StudentMapperAnnotation {

    /**
     * 以注解的方式实现ssm整合
     * @return
     */
    @Select("SELECT * FROM student")
    List<Student> getAll();

    @Select("SELECT * FROM student where id=#{id}")
    Student getById(@Param("id") int id);

}
