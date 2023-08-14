package com.test.tools;

import com.test.task.Entry;
import com.test.task.TestObjectResultData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String [] args) throws Exception{
//        for(int i = 1 ; i < 201 ; i++) {
//            String Path;
//            List<Object> data;
//            String excelName = "test1.xlsx";
//            List<TestObjectResultData> res = new ArrayList<TestObjectResultData>();
//            Path = System.getProperty("user.dir") + System.getProperty("file.separator") + excelName;
//            List<List<Object>> data1 = CreatAndReadExcel.readExcel(new File(Path));
//            Entry e = new Entry(data1.get(0));
//            Entry.BeforeClass();
//            e.testBefore();
//            e.Test();
//            e.testAfter();
//            //Entry.afterClass();
//            tool.sleep(5000);
//        }

        System.out.println(getStr("hello world"));
        }

        public static String getStr(String str){
            String str2 = "";
            for(int i = 0 ; i < str.length() ; i++){
                str2 = str.charAt(i) + str2;
            }
            return str2;
        }

}
