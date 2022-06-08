import com.lotushint.crowd.entity.Admin;
import com.lotushint.crowd.mapper.AdminMapper;
import com.lotushint.crowd.service.api.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/11 15:19
 * @package PACKAGE_NAME
 * @description
 */
//RunWith与ContextConfiguration指定xml的作用与ApplicationContext context = new ClassPathXmlApplicationContext("spring-persist-mybatis.xml");类似
//前者通过让测试在Spring容器环境下执行，使得 DataSource 可以被自动注入，后者通过 getBean 方法得到DataSource
// 在类上标记必要的注解，Spring整合Junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminService adminService;

    /**
     * 测试数据库连接
     *
     * @throws SQLException
     */
    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * 测试插入数据
     */
    @Test
    public void testInsertAdmin() {
        Admin admin = new Admin(null, "tom", "123456", "汤姆", "tom@qq.com", null);
        int count = adminMapper.insert(admin);
        /*
         如果在实际开发中，所有想查看数值的地方都使用sout方式打印，会给项目上线运行带来问题！
         sout本质上是一个IO操作，通常IO的操作是比较消耗性能的。如果项目中sout很多，那么对性能的影响就比较大了。
         即使上线前专门花时间删除代码中的sout，也很可能有遗漏，而且非常麻烦。
         而如果使用日志系统，那么通过日志级别就可以批量的控制信息的打印。
         */
        System.out.println("受影响的行数=" + count);
    }

    /**
     * 测试日志
     */
    @Test
    public void testLog() {

        // 1.获取Logger对象，这里传入的Class对象就是当前打印日志的类
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);

        // 2.根据不同日志级别打印日志
        logger.debug("Hello I am Debug level!!!");
        logger.debug("Hello I am Debug level!!!");
        logger.debug("Hello I am Debug level!!!");

        logger.info("Info level!!!");
        logger.info("Info level!!!");
        logger.info("Info level!!!");

        logger.warn("Warn level!!!");
        logger.warn("Warn level!!!");
        logger.warn("Warn level!!!");

        logger.error("Error level!!!");
        logger.error("Error level!!!");
        logger.error("Error level!!!");


    }

    /**
     *
     */
    @Test
    public void testTx() {
        Admin admin = new Admin(null, "jerry", "123456", "杰瑞", "jerry@qq.com", null);
        adminService.saveAdmin(admin);
    }

    /**
     * 准备测试数据
     */
    @Test
    public void test() {
        for(int i = 0; i < 238; i++) {
            adminMapper.insert(new Admin(null, "loginAcct"+i, "userPswd"+i, "userName"+i, "email"+i, null));
        }
    }
}
