import com.lotushint.crud.bean.Department;
import com.lotushint.crud.dao.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/6 19:13
 * @package com.lotushint.crud.test
 * @description 测试dao层的工作
 * 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 * 3、直接autowired要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 测试DepartmentMapper
     */
    @Test
    public void testCRUD() {
//    // 1、创建SpringIOC容器
//    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//    // 2、从容器中获取mapper
//    DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);

        System.out.println(departmentMapper);

        //1、插入几个部门
        departmentMapper.insertSelective(new Department(null, "开发部"));
        departmentMapper.insertSelective(new Department(null, "测试部"));
    }
}
