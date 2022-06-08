package com.lotushint.rest.controller;

import com.lotushint.rest.bean.Employee;
import com.lotushint.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author hefan
 * @package com.lotushint.rest.controller
 * @date 2021/11/18 11:27
 * @description
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 查询所有员工数据
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    /**
     * 执行保存
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    /**
     * 实现回显
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getElementById(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    /**
     * 执行更新
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}
