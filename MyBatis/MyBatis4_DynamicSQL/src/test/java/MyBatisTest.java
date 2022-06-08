import com.lotushint.mybatis.bean.Department;
import com.lotushint.mybatis.bean.Employee;
import com.lotushint.mybatis.dao.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hefan
 * @package PACKAGE_NAME
 * @date 2022/1/12 16:09
 * @description
 */
public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputAsStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputAsStream);
    }

    @Test
    public void testDynamicSQL() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //select * from tbl_employee where id=? and last_name like ?
            //测试if\where
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(1, "ad", null, null);
            List<Employee> emps = mapper.getEmpsByConditionIf(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
            //查询的时候如果某些条件没带可能sql拼装会有问题
            //1、给where后面加上1=1，以后的条件都and xxx.
            //2、mybatis使用<where></where>标签来将所有的查询条件包括在内。mybatis就会将where标签中拼装的sql，多出来的and或者or去掉
            //<where></where>只会去掉第一个多出来的and或者or。

            System.out.println("测试Trim");
            //测试Trim
            List<Employee> emps2 = mapper.getEmpsByConditionTrim(employee);
            for (Employee emp : emps2) {
                System.out.println(emp);
            }

            System.out.println("测试choose");
            //测试choose
            List<Employee> list = mapper.getEmpsByConditionChoose(employee);
            for (Employee emp : list) {
                System.out.println(emp);
            }

            System.out.println("测试set");
            //测试set
            mapper.updateEmp(employee);
            //注意要提交
            openSession.commit();

            System.out.println("测试foreach");
            //测试foreach
            List<Employee> lists = mapper.getEmpsByConditionForeach(Arrays.asList(1, 2, 3, 4, 5));
            for (Employee emp : lists) {
                System.out.println(emp);
            }
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testBatchSave() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee(null, "smith0x11", "1", "smith0x11@atguigu.com", new Department(1)));
            emps.add(new Employee(null, "allen0x11", "0", "allen0x11@atguigu.com", new Department(1)));
            mapper.addEmps(emps);
            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testInnerParam() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee();
            employee.setLastName("i");
            List<Employee> list = mapper.getEmpsTestInnerParameter(employee);
            for (Employee emp : list ) {
                System.out.println(emp);
            }
        } finally {
            openSession.close();
        }
    }
}
