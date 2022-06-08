package com.lotushint.boot.service;

import com.lotushint.boot.domain.Student;

import java.util.List;

public interface StudentService {

    /**
     * 分页参数
     */
    List<Student> getAll(Integer pageNum, Integer pageSize);

    Student get(Integer id);

}
