import com.lotushint.mybatis.bean.Employee;
import com.lotushint.mybatis.bean.EmployeeExample;
import com.lotushint.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/28 9:57
 * @package PACKAGE_NAME
 * @description
 */
public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * ็ๆๆไปถ
     *
     * @throws Exception
     */
    @Test
    public void testMBG() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("src/main/resources/mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

//    @Test
//    public void testMybatisSimple() throws IOException {
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession openSession = sqlSessionFactory.openSession();
//        try {
//            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
//            List<Employee> list = mapper.selectAll();
//            for (Employee emp : list) {
//                System.out.println(emp);
//            }
//        } finally {
//            openSession.close();
//        }
//    }

    @Test
    public void testMybatis3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            //xxxExampleๅฐฑๆฏๅฐ่ฃๆฅ่ฏขๆกไปถ็
            //1ใๆฅ่ฏขๆๆ
            System.out.println("ๆฅ่ฏขๆๆ:");
            List<Employee> emps = mapper.selectByExample(null);
            for (Employee emp : emps) {
                System.out.println(emp);
            }

            //2.ๆฅ่ฏขๅๅทฅๅๅญไธญๆeๅญๆฏ็๏ผๅๅๅทฅๆงๅซๆฏ1็
            //ๅฐ่ฃๅๅทฅๆฅ่ฏขๆกไปถ็example
            System.out.println("ๆฅ่ฏขๅๅทฅๅๅญไธญๆeๅญๆฏ็๏ผๅๅๅทฅๆงๅซๆฏ1็:");
            EmployeeExample example = new EmployeeExample();
            //ๅๅปบไธไธชCriteria๏ผ่ฟไธชCriteriaๅฐฑๆฏๆผ่ฃๆฅ่ฏขๆกไปถ
            //select id, last_name, email, gender, d_id from tbl_employee
            //WHERE ( last_name like ? and gender = ? ) or email like "%e%"
            EmployeeExample.Criteria criteria = example.createCriteria();
            criteria.andLastNameLike("%l%");
            criteria.andGenderEqualTo("1");

            EmployeeExample.Criteria criteria1 = example.createCriteria();
            criteria1.andEmailLike("%e%");
            example.or(criteria1);

            List<Employee> emps2 = mapper.selectByExample(example);
            for (Employee emp : emps2) {
                System.out.println(emp.getdId());
            }
        } finally {
            openSession.close();
        }
    }
}