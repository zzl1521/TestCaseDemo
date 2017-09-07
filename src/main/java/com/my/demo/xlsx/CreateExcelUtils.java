package com.my.demo.xlsx;

import org.apache.poi.hssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhile on 2017/8/28.
 */
public class CreateExcelUtils {

    public static void main(String[] args) {
        create();

    }

    public static void create() {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("用户表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell( 0);
        cell.setCellValue("id");
        cell.setCellStyle(style);
        cell = row.createCell( 1);
        cell.setCellValue("name");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("age");
        cell.setCellStyle(style);

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        List<User> users = getUser();

        for (int i=0;i<users.size();i++) {
            User user=users.get(i);
            row = sheet.createRow((int) i + 1);
            // 第四步，创建单元格，并设置值
            row.createCell(0).setCellValue(user.getId());
            row.createCell( 1).setCellValue(user.getName());
            row.createCell( 2).setCellValue(user.getAge());
        }
        // 第六步，将文件存到指定位置
        try {
            FileOutputStream fout = new FileOutputStream("C:\\Users\\zhangzhile\\Desktop\\sql.xlsx");
            wb.write(fout);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static List<User> getUser() {
        List<User> lists = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i);
            user.setName("例子" + i);
            user.setAge(String.valueOf(10 + i));
            lists.add(user);
        }
        return lists;
    }

}
