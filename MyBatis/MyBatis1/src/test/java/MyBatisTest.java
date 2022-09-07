import com.lotushint.mybatis.bean.Employee;
import com.lotushint.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hefan
 * @package PACKAGE_NAME
 * @date 2022/1/12 16:09
 * @description
 * 1、接口式编程 <br>
 * 原生：		Dao		====>  DaoImpl<br>
 * com.lotushint.mybatis：	Mapper	====>  xxMapper.xml<br>
 * <p>
 * 2、SqlSession代表和数据库的一次会话；用完必须关闭；<br>
 * 3、SqlSession和connection一样她都是非线程安全。每次使用都应该去获取新的对象。<br>
 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。<br>
 * （将接口和xml进行绑定）<br>
 * EmployeeMapper empMapper =	sqlSession.getMapper(EmployeeMapper.class);<br>
 * 5、两个重要的配置文件：<br>
 * mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统运行环境信息<br>
 * sql映射文件：保存了每一个sql语句的映射信息：<br>
 * 将sql抽取出来。<br>
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
     * 1.根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象<br>
     * 有数据源一些运行环境信息<br>
     * 2.sql映射文件；配置了每一个sql,以及sql的封装规则等<br>
     * 3.将sql映射文件注册在全局配置文件中<br>
     * 4.写代码：<br>
     * 1）根据全局配置文件得到SqlSessionFactory;<br>
     * 2）使用sqlSession工厂，获取sqlSession对象使用他来执行增删改查<br>
     * 一个sqlSession就是代表和数据库的一次会话，用完关闭<br>
     * 3）使用sql的唯一标志来告诉MyBatis执行哪个sql.sql都是保存在sql映射文件中的<br>
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        /*
         2.获取sqlSession实例，能直接执行已经映射的sql语句
         */
        SqlSession openSession = sqlSessionFactory.openSession();

        /*
        推荐使用      namespace + id
         */
        try {
            Employee employee = openSession.selectOne("com.lotushint.mybatis.dao.EmployeeMapper.getEmpById", 1);
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
}
