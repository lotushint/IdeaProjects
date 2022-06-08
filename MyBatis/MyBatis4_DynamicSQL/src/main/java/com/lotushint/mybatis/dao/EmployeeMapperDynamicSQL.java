package com.lotushint.mybatis.dao;

import com.lotushint.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/25 20:17
 * @package com.lotushint.mybatis.dao
 * @description
 */
public interface EmployeeMapperDynamicSQL {
    public List<Employee> getEmpsByConditionIf(Employee employee);

    public List<Employee> getEmpsByConditionTrim(Employee employee);

    public List<Employee> getEmpsByConditionChoose(Employee employee);

    public void updateEmp(Employee employee);

    /**
     * 查询员工id'在给定集合中的
     */
//    public List<Employee> getEmpsByConditionForeach(List<Integer> ids);
//    可以使用注解@Param更改EmployeeMapperDynamicSQL.xml中foreach标签属性collectiond的值，不改则collection="list"
    public List<Employee> getEmpsByConditionForeach(@Param("ids") List<Integer> ids);

    /**
     * 批量保存
     *
     * @param emps
     */
    public void addEmps(@Param("emps") List<Employee> emps);

    public List<Employee> getEmpsTestInnerParameter(Employee employee);
}
