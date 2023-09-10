package com.my_io.basic_usage;

import cn.hutool.core.util.RandomUtil;
import com.my_io.PathUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author : chengdu
 * @date :  2023/9/10-09
 **/
public class FileOutPutDemo {

    @Test
    public void testOneWrite()throws Exception{
        File file = new File(PathUtils.getProjectPath() + File.separator + "c" + ".txt");
        String content = RandomUtil.randomNumbers(20) + "_";
        System.out.println("content:"+content);

        FileOutputStream outputStream = new FileOutputStream(file,false) ;
        byte[] bytes = content.getBytes("UTF-8");
        for (byte b:bytes){
            outputStream.write(b);
        }
        outputStream.flush();
        outputStream.close();
    }

    @Test
    public void testByteWrite()throws Exception{
        File file = new File(PathUtils.getProjectPath() + File.separator + "c" + ".txt");
        String content = RandomUtil.randomNumbers(20) + "_";
        System.out.println("content:"+content);

        FileOutputStream outputStream = new FileOutputStream(file,false) ;
        byte[] bytes = content.getBytes("UTF-8");
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }

    @Test
    public void testCopyFile()throws Exception{
        File file = new File("D:\\data\\Google Java 编程风格指南.xmind");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.read(buffer) != -1) {
            System.out.println("finish read");
        }
        inputStream.close();


        File copyFile = new File("D:\\data\\Google Java 编程风格指南2.xmind");
        FileOutputStream outputStream = new FileOutputStream(copyFile,false) ;
        outputStream.write(buffer);
        outputStream.flush();
        outputStream.close();
        System.out.println("finish write");
    }

    @Test
    public void testCopyFile2()throws Exception{
        File file = new File("D:\\data\\Google Java 编程风格指南.xmind");
        File copyFile = new File("D:\\data\\Google Java 编程风格指南3.xmind");
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(copyFile,false) ;
        byte[] buffer = new byte[24];
        while (inputStream.read(buffer,0,buffer.length) != -1) {
            outputStream.write(buffer);
        }

        inputStream.close();
        outputStream.flush();
        outputStream.close();
        System.out.println("finish write");
    }



}
