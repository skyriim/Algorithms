package com.s.z.LeetCode.BigFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author ：Zhang Shuo
 * @date ：Created in 2019/9/2 11:56
 * @description：
 * @modified By：
 */
public class ReadPortion {
    public static void readFirstLines(String path,int lineCount) throws Exception{
        //File file = new File("F:\\gongtu_dbbc011_analysis_data\\201908.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String str;
        int i=0;
        while ((i++<lineCount)&&((str = reader.readLine()) != null)) {
            System.out.println(str);
        }
        //关闭流
        reader.close();
    }
}
