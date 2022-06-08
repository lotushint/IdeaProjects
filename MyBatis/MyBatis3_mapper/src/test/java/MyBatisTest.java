import com.lotushint.mybatis.bean.Department;
import com.lotushint.mybatis.bean.Employee;
import com.lotushint.mybatis.dao.DepartmentMapper;
import com.lotushint.mybatis.dao.EmployeeMapper;
import com.lotushint.mybatis.dao.EmployeeMapperAnnotation;
import com.lotushint.mybatis.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author hefan
 * @package PACKAGE_NAME
 * @date 2022/1/12 16:09
 * @description 1、接口式编程
 * 原生：		Dao		====>  DaoImpl
 * com.lotushint.mybatis：	Mapper	====>  xxMapper.xml
 * <p>
 * 2、SqlSession代表和数据库的一次会话；用完必须关闭；
 * 3、SqlSession和connection一样她都是非线程安全。每次使用都应该去获取新的对象。
 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
 * （将接口和xml进行绑定）
 * EmployeeMapper empMapper =	sqlSession.getMapper(EmployeeMapper.class);
 * 5、两个重要的配置文件：
 * mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统运行环境信息
 * sql映射文件：保存了每一个sql语句的映射信息：
 * 将sql抽取出来。
 */
public class MyBatisTest {
    /*
    1.根据xml配置文件(全局配置文件)创建SqlSessionFactory对象
    */
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 1.根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
     * 有数据源一些运行环境信息
     * 2.sql映射文件；配置了每一个sql,以及sql的封装规则等
     * 3.将sql映射文件注册在全局配置文件中
     * 4.写代码：
     * 1）根据全局配置文件得到SqlSessionFactory;
     * 2）使用sqlSession工厂，获取sqlSession对象使用他来执行增删改查
     * 一个sqlSession就是代表和数据库的一次会话，用完关闭
     * 3）使用sql的唯一标志来告诉MyBatis执行哪个sql.sql都是保存在sql映射文件中的
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        /*
         2.获取sqlsession实例，能直接执行已经映射的sql语句
         */
        SqlSession openSession = sqlSessionFactory.openSession();

        /*
        推荐使用namespace+id
         */
        try {
            Employee employee = openSession.selectOne("com.lotushint.mybatis.EmployeeMapper.selectEmployee", 1);
            System.out.println(employee);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test01() throws IOException {
// 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(mapper.getClass());
            System.out.println(employee);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test02() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperAnnotation mapper = openSession.getMapper(EmployeeMapperAnnotation.class);
            Employee empById = mapper.getEmpById(1);
            System.out.println(empById);
        } finally {
            openSession.close();
        }
    }

    /**
     * 测试增删改
     * 1.mybatis允许增删改直接定义以下类型返回值
     * Integer、Long、Boolean
     * 2.我们需要手动提交数据
     * <p>
     * sqlSessionFactory.openSession();         ===》    手动提交
     * sqlSessionFactory.openSession(true);     ===》    自动提交
     *
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取到的sqlSession不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

//            1.测试添加
            Employee employee = new Employee(null, "3270056@gmail", "lotus", "1");
            mapper.addEmp(employee);
            System.out.println(employee.getId());

//            2.测试修改
//            Employee employee = new Employee(1,"327005698@gmail","hint","1");
//            Boolean updateEmp = mapper.updateEmp(employee);
//            System.out.println(updateEmp);

//            3.测试删除
//            mapper.deleteEmpById(3);

            //提交数据
            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test04() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取到的sqlSession不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

//            Employee employee = mapper.getEmpByIdAndLastName(1,"hint");

//            Map<String ,Object> map = new HashMap<>();
//            map.put("id",4);
//            map.put("lastName","lotus");
//            Employee employee = mapper.getEmpByMap(map);
//            System.out.println(employee);

//            List<Employee> like = mapper.getEmpsByLastNameLike("%o%");
//            for (Employee employee : like) {
//                System.out.println(employee);
//            }

//            Map<String,Object> map = mapper.getEmpByIdReturnMap(1);
//            System.out.println(map);

			Map<Integer, Employee> map = mapper.getEmpByLastNameLikeReturnMap("%o%");
			System.out.println(map);

        } finally {
            openSession.close();
        }
    }

    @Test
    public void test05() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
//            Employee empById = mapper.getEmpById(1);
//            System.out.println(empById);

//            Employee empAndDept = mapper.getEmpAndDept(1);
//            System.out.println(empAndDept);
//            System.out.println(empAndDept.getDept());

            Employee empAndDeptStep = mapper.getEmpByIdStep(1);
//            System.out.println(empAndDeptStep);
            System.out.println(empAndDeptStep.getLastName());
//            System.out.println(empAndDeptStep.getDept());//不会把部门信息一起查出来，是使用的时候才会去查询（看打印的sql语句）
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test06() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
//            Department deptByIdPlus = mapper.getDeptByIdPlus(1);
//            System.out.println(deptByIdPlus);
//            System.out.println(deptByIdPlus.getEmps());

            Department deptByIdStep = mapper.getDeptByIdStep(1);
            System.out.println(deptByIdStep.getDepartmentName());
            System.out.println(deptByIdStep.getEmps());
        } finally {
            openSession.close();
        }
    }
}
