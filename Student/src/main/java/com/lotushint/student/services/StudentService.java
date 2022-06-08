package com.lotushint.student.services;

import com.lotushint.student.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/11 13:34
 * @package com.lotushint.student.services
 * @description
 */
public interface StudentService {
    Student save(Student student);

    void delete(Integer id);

    Student findStuById(Integer id);

    List<Student> findStuByName(String name);

    Page<Student> findAll(int page, int pageSize);

}
