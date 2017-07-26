package com.my.demo.csv;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * Created by zhangzhile on 2017/5/25.
 */
public class CsvParserTest {

    public Reader getReader(String relativePath) throws Exception{
        File file = new File(relativePath);
        return new InputStreamReader(new FileInputStream(file), "UTF-8");
    }

    public static void main(String[] args) throws Exception{
        CsvParserSettings settings = new CsvParserSettings();
        // 文件中使用 '\n' 作为行分隔符
        // 确保像MacOS和Windows这样的系统
        // 也可以正确处理（MacOS使用'\r'；Windows使用'\r\n'）
        settings.getFormat().setLineSeparator("\t");

        // 创建CSV解析器
        CsvParser parser = new CsvParser(settings);

        // 一行语句处理所有行
        List<String[]> allRows = parser.parseAll(new CsvParserTest().getReader("C:\\Users\\zhangzhile\\Desktop\\sql.csv"));
        for (String[] strs:allRows){
            for(String str:strs){
                System.out.print(str+"|");
            }
            System.out.println("----------------------------------------------------------------");
        }
    }
}
