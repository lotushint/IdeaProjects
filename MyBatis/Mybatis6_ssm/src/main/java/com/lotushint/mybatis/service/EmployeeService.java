package com.lotushint.mybatis.service;

import com.lotushint.mybatis.bean.Employee;
import com.lotushint.mybatis.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/29 12:10
 * @package com.lotushint.mybatis.service
 * @description
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getEmps(){
        return employeeMapper.getemps();
    }
}
