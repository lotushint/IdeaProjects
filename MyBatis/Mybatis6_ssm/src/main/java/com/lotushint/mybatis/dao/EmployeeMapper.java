package com.lotushint.mybatis.dao;

import com.lotushint.mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public List<Employee> getemps();
}
