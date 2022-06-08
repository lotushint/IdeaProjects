package com.lotushint.mybatis.dao;

import com.lotushint.mybatis.bean.Employee;

public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
}
