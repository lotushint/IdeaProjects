package com.lotushint.boot.service;

import com.lotushint.boot.domain.Student;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/14 9:36
 * @package com.lotushint.boot.service
 * @description
 */
public interface StudentService {

    /**
     * 分页参数
     * @param pageNum 页码
     * @param pageSize 记录条数
     * @return
     */
    List<Student> getAll(Integer pageNum, Integer pageSize);

    Student get(Integer id);

}
