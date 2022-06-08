package com.lotushint.student.services;

import com.lotushint.student.dao.StudentDao;
import com.lotushint.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/11 13:35
 * @package com.lotushint.student.services
 * @description
 */
@Service  /**告诉springboot控制层实现类不然找不到注入*/
public class StudentServiceImpl implements StudentService {

    @Autowired /**自动注入*/
    private StudentDao studentDao;

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public Student findStuById(Integer id) {
        return studentDao.findStudentById(id);
    }

    @Override
    public List<Student> findStuByName(String name) {
        return studentDao.findStuByName(name);
    }

    @Override
    public Page<Student> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return studentDao.findAll(pageable);
    }
}