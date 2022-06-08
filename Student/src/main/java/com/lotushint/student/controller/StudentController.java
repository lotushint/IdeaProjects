package com.lotushint.student.controller;

import com.lotushint.student.entity.Student;
import com.lotushint.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/11 13:36
 * @package com.lotushint.student.controller
 * @description
 */
@RestController  /**控制层注解并实现返回格式为json*/
@RequestMapping("/stu") /**配置访问路径*/
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add") /**post请求*/
    public Student save(Student student) {
        return studentService.save(student);
    }

    @PostMapping("/update")
    public Student update(Student student) {
        Student s = studentService.findStuById(student.getId());
        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setSex(student.getSex());
        return studentService.save(s);
    }

    @GetMapping("/del/{id}") /**get请求 RESTful风格*/
    public String del(@PathVariable int id) {
        studentService.delete(id);
        return "yes";
    }

    @GetMapping("findByName/{name}")
    public List<Student> findByName(@PathVariable String name) {
        return studentService.findStuByName(name);
    }

    @GetMapping("/query")
    public Page<Student> findByPage(Integer page, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin","*");//解决跨域请求

        if (page == null || page <= 0) {
            page = 0;
        } else {
            page -= 1;
        }
        return studentService.findAll(page, 5);
    }

}