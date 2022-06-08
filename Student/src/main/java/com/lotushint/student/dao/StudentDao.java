package com.lotushint.student.dao;

import com.lotushint.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/11 13:31
 * @package com.lotushint.student.dao
 * @description
 */
public interface StudentDao extends JpaRepository<Student, Integer> {

    /**
     * 简单的增删改查不需要写，这个只不过为了辨别写了个名，不写也有底层的findById方法
     * @param id
     * @return
     */
    Student findStudentById(Integer id);

    /**
     * 稍复杂的SQL语句需要自定义，格式如下
     * @param name
     * @return
     */
    @Query(name = "findStuByName", nativeQuery = true, value = "select * from student where name=:name")
    List<Student> findStuByName(@Param("name") String name);
}
