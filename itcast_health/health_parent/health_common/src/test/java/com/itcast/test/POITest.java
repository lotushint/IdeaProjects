package com.itcast.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/28 19:36
 * @package com.itcast.test
 * @description
 */
public class POITest {
    @Test
    public void test1() throws Exception {
        // 加载指定文件，创建 Excel 对象（工作簿）
        XSSFWorkbook excel = new XSSFWorkbook(new FileInputStream(new File("D:\\poi.xlsx")));
        // 读取 Excel 文件中第一个 Sheet 标签页
        XSSFSheet sheet = excel.getSheetAt(0);

        // 遍历 Sheet 标签页，获得每一行数据
        for (Row row : sheet) {
            // 遍历行，获得每个单元格对象
            for (Cell cell : row) {
                System.out.println(cell.getStringCellValue());
            }
        }
        // 关闭资源
        excel.close();
    }

    @Test
    public void test2() throws IOException {
        // 创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook("D:\\poi.xlsx");
        // 获取工作表，既可以根据工作表的顺序获取，也可以根据工作表的名称获取
        XSSFSheet sheet = workbook.getSheetAt(0);

        // 获取当前工作表最后一行的行号，行号从 0 开始
        int lastRowNum = sheet.getLastRowNum();
        System.out.println("lastRowNum = " + lastRowNum);
        for (int i = 0; i <= lastRowNum; i++) {
            // 根据行号获取行对象
            XSSFRow row = sheet.getRow(i);
            // 获得当前行最后一个单元格索引
            short lastCellNum = row.getLastCellNum();
            System.out.println("lastCellNum = " + lastCellNum);

            for (short j = 0; j < lastCellNum; j++) {
                // 根据单元格索引获得单元格对象
                XSSFCell cell = row.getCell(j);
                String value = cell.getStringCellValue();
                System.out.println(value);
            }
        }
        workbook.close();
    }

    @Test
    public void test3() throws Exception {
        // 在内存中创建一个 Excel 文件
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建工作表，指定工作表名称
        XSSFSheet sheet = workbook.createSheet("个人信息");

        // 创建行，0表示第一行
        XSSFRow row = sheet.createRow(0);
        // 创建单元格，0表示第一个单元格
        row.createCell(0).setCellValue("编号");
        row.createCell(1).setCellValue("名称");
        row.createCell(2).setCellValue("年龄");

        XSSFRow dataRow1 = sheet.createRow(1);
        dataRow1.createCell(0).setCellValue("1");
        dataRow1.createCell(1).setCellValue("小明");
        dataRow1.createCell(2).setCellValue("10");

        XSSFRow dataRow2 = sheet.createRow(2);
        dataRow2.createCell(0).setCellValue("2");
        dataRow2.createCell(1).setCellValue("小王");
        dataRow2.createCell(2).setCellValue("20");

        //通过输出流将 workbook 对象下载到磁盘
        FileOutputStream out = new FileOutputStream("D:\\person.xlsx");
        workbook.write(out);
        out.flush();
        out.close();
        workbook.close();
    }
}
