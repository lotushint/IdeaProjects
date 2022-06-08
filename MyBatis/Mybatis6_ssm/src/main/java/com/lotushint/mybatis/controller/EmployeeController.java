package com.lotushint.mybatis.controller;

import com.lotushint.mybatis.bean.Employee;
import com.lotushint.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/29 12:07
 * @package com.lotushint.mybatis.controller
 * @description
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/getemps")
    public String emps(Map<String, Object> map) {
        List<Employee> emps = employeeService.getEmps();
        map.put("allEmps",emps);
        return "list";
    }
}
