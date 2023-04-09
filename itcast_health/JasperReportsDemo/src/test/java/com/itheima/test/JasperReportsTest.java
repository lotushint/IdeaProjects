package com.itheima.test;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBaseField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/8 14:30
 * @package com.itheima.test
 * @description
 */
public class JasperReportsTest {
    @Test
    public void testJasperReports() throws Exception {
        String jrxmlPath = "D:\\lotushint\\MyProjects\\JetbrainsProjects\\IdeaProjects\\itcast_health\\JasperReportsDemo\\src\\main\\resources\\demo.jrxml";
        String jasperPath = "D:\\lotushint\\MyProjects\\JetbrainsProjects\\IdeaProjects\\itcast_health\\JasperReportsDemo\\src\\main\\resources\\demo.jasper";

        //编译模板
        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

        //构造数据
        Map paramters = new HashMap();
        paramters.put("reportDate", "2019-10-10");
        paramters.put("company", "itcast");
        List<Map> list = new ArrayList();
        Map map1 = new HashMap();
        map1.put("name", "xiaoming");
        map1.put("address", "beijing");
        map1.put("email", "xiaoming@itcast.cn");
        Map map2 = new HashMap();
        map2.put("name", "xiaoli");
        map2.put("address", "nanjing");
        map2.put("email", "xiaoli@itcast.cn");
        list.add(map1);
        list.add(map2);

        //填充数据
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, paramters, new JRBeanCollectionDataSource(list));

        //输出文件
        String pdfPath = "D:\\test.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfPath);
    }

    /**
     * JDBC数据源方式填充数据
     *
     * @throws Exception
     */
    @Test
    public void testReport_JDBC() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.245.129:3306/health?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8", "root", "123456");

        String jrxmlPath = "D:\\lotushint\\MyProjects\\JetbrainsProjects\\IdeaProjects\\itcast_health\\JasperReportsDemo\\src\\main\\resources\\demo1.jrxml";
        String jasperPath = "D:\\lotushint\\MyProjects\\JetbrainsProjects\\IdeaProjects\\itcast_health\\JasperReportsDemo\\src\\main\\resources\\demo1.jasper";

        //编译模板
        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

        //构造数据
        Map parameters = new HashMap();
        parameters.put("company", "传智播客");

        //填充数据---使用JDBC数据源方式填充
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, parameters, connection);

        //输出文件
        String pdfPath = "D:\\test.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfPath);
    }

    /**
     * JavaBean数据源方式填充数据
     *
     * @throws Exception
     */
    @Test
    public void testReport_JavaBean() throws Exception {
        String jrxmlPath = "D:\\lotushint\\MyProjects\\JetbrainsProjects\\IdeaProjects\\itcast_health\\JasperReportsDemo\\src\\main\\resources\\demo2.jrxml";
        String jasperPath = "D:\\lotushint\\MyProjects\\JetbrainsProjects\\IdeaProjects\\itcast_health\\JasperReportsDemo\\src\\main\\resources\\demo2.jasper";

        //编译模板
        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

        //构造数据
        Map paramters = new HashMap();
        paramters.put("company", "传智播客");

        List<Map> list = new ArrayList();

        Map map1 = new HashMap();
        map1.put("tName", "入职体检套餐");
        map1.put("tCode", "RZTJ");
        map1.put("tAge", "18-60");
        map1.put("tPrice", "500");

        Map map2 = new HashMap();
        map2.put("tName", "阳光爸妈老年健康体检");
        map2.put("tCode", "YGBM");
        map2.put("tAge", "55-60");
        map2.put("tPrice", "500");
        list.add(map1);
        list.add(map2);

        //填充数据---使用JavaBean数据源方式填充
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, paramters, new JRBeanCollectionDataSource(list));
        //输出文件
        String pdfPath = "D:\\test.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfPath);
    }
}
