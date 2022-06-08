package com.lotushint.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lotushint.boot.domain.Student;
import com.lotushint.boot.mapper.StudentMapper;
import com.lotushint.boot.mapper.annotationVersion.StudentMapperAnnotation;
import com.lotushint.boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/14 9:36
 * @package com.lotushint.boot.service.imp
 * @description
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    /**
     * xml方式整合ssm
     */
    private StudentMapper studentMapper;

//    @Autowired
//    /**
//     *注解方式整合
//     */
//    private StudentMapperAnnotation studentMapper;

    @Override
    public List<Student> getAll(Integer pageNum, Integer pageSize) {
        //在查询之前设置分页,利用Mybatis的分页插件实现分页
        PageHelper.startPage(pageNum, pageSize);

        List<Student> list = studentMapper.getAll();
        //对page结果进行包装
        PageInfo<Student> info = new PageInfo<>(list);
        return info.getList();
    }

    @Override
    public Student get(Integer id) {
        return studentMapper.getById(id);
    }

}