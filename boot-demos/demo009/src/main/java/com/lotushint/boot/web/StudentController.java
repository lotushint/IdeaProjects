package com.lotushint.boot.web;

import com.lotushint.boot.domain.Student;
import com.lotushint.boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<Student> find(@RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum, @RequestParam(name="pageSize" ,required = false,defaultValue = "20") Integer pageSize) {
        return studentService.getAll(pageNum,pageSize);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student get(@PathVariable(name = "id") Integer id) {
        return studentService.get(id);
    }

}
