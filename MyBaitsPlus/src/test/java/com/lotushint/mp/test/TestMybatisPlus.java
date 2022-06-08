package com.lotushint.mp.test;

import com.baomidou.mybatisplus.plugins.Page;
import com.lotushint.mp.beans.Employee;
import com.lotushint.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/23 16:05
 * @package com.lotushint.mp.test
 * @description
 */
public class TestMybatisPlus {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");

    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);

    /**
     * 通用删除操作
     */
    @Test
    public void testCommonDelete() {
        //1.根据id进行除
        Integer result = employeeMapper.deleteById(13);
        System.out.println("result:" + result);

        //2.根据条件进行删除
        HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("age", "21");
        columnMap.put("last_name", "MP");
        columnMap.put("email", "46564564@qq.com");
        Integer result1 = employeeMapper.deleteByMap(columnMap);
        System.out.println("result1:" + result1);

        //3.批量删除
        ArrayList<Integer> idList = new ArrayList<>();
        idList.add(10);
        idList.add(11);
        Integer result2 = employeeMapper.deleteBatchIds(idList);
        System.out.println("result2:" + result2);
    }

    /**
     * 通用查询操作
     */
    @Test
    public void testCommonSelect() {

        //1.通过id查询
//        Employee employee = employeeMapper.selectById(7);
//        System.out.println(employee);

        //2.通过多个列进行查询 id + lastName,根据非空属性作为查询条件来进行查询
        //注意selectOne只能查询一条数据，如果有多条数据会出问题
//        Employee employee = new Employee();
//        employee.setId(7);
//        employee.setLastName("MP");
//        Employee selectOne = employeeMapper.selectOne(employee);
//        System.out.println(selectOne);

        //3.通过多个id查询 <foreach>
//        ArrayList<Integer> idList = new ArrayList<>();
//        idList.add(4);
//        idList.add(5);
//        idList.add(6);
//        idList.add(7);
//        List<Employee> emps = employeeMapper.selectBatchIds(idList);
//        System.out.println(emps);

        //4.通过map封装条件查询
//        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("last_name","Tom");
//        columnMap.put("gender",1);
//        List<Employee> emps = employeeMapper.selectByMap(columnMap);
//        System.out.println(emps);

        //5.分页查询
        List<Employee> emps = employeeMapper.selectPage(new Page<>(2, 2), null);
        System.out.println(emps);

    }

    /**
     * 通用更新操作
     */
    @Test
    public void testCommonUpdate() {
        Employee employee = new Employee();
        employee.setId(5);
        employee.setLastName("玛利亚老师");
        employee.setEmail("mly@sina.com");
        employee.setGender(0);

//        employee.setAge(33);

        //不会更改age
//        Integer result = employeeMapper.updateById(employee);

        //age会变为null
        Integer result = employeeMapper.updateAllColumnById(employee);
    }

    /**
     * 通用插入操作
     */
    @Test
    public void testCommonInsert() {
        //初始化Employee对象
        Employee employee = new Employee();
        employee.setLastName("MP");
        employee.setEmail("46564564@qq.com");
//        employee.setGender(1);
//        employee.setAge(20);
        employee.setSalary(20000.0);
        //插入到数据库
//        insert方法在插入时，会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到 SQL语句中
//        Integer result = employeeMapper.insert(employee);
//        insertAllColumn方法在插入时，不管属性是否为空，属性所对应的字段都会出现到 SQL语句中
        Integer result = employeeMapper.insertAllColumn(employee);
        System.out.println("result: " + result);

        //获取当前数据在数据库中的主键值
        Integer key = employee.getId();
        System.out.println("key:" + key);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource ds = ioc.getBean("dataSource", DataSource.class);
        System.out.println(ds);
        Connection connection = ds.getConnection();
        System.out.println(connection);
    }
}
