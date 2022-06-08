package com.lotushint.mybatis.dao;

import com.lotushint.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    /**
     * 多条记录封装一个map:Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javabean对象
     * @param lastName
     * @return
     */
    @MapKey("id")//告诉mybatis封装这个map的时候使用哪个属性作为主键
    public Map<Integer, Employee> getEmpByLastNameLikeReturnMap(String lastName);

    /**
     * 返回一条记录的map:key就是列名，值就是对应的值
     * @param id
     * @return
     */
    public Map<String, Object> getEmpByIdReturnMap(Integer id);

    public List<Employee> getEmpsByLastNameLike(String lastName);

//    public Employee getEmpByIdAndLastName(Integer id,String lastName);
    public Employee getEmpByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);

    public Employee getEmpByMap(Map<String,Object> map);

    public Employee getEmpById(Integer id);

    public Long addEmp(Employee employee);

    public Boolean updateEmp(Employee employee);

    public void deleteEmpById(Integer id);
}
