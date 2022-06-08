package com.lotushint.boot.mapper;

import com.lotushint.boot.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/14 9:32
 * @package com.lotushint.boot.mapper
 * @description xml方式ssm整合
 */
public interface StudentMapper {

    List<Student> getAll();

    Student getById(@Param("id") int id);

}
