package com.my_io.basic_usage;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import com.my_io.PathUtils;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author : chengdu
 * @date :  2023/9/9-09
 **/
public class FileInputDemo {

    @Test
    public void testA() {
        int count = 10;
        for (System.out.println("section a " + RandomUtil.randomLong(100000L)); count > 0; System.out.println("section b " + RandomUtil.randomLong(100000L))) {
            count--;
            System.out.println("FileInputDemo.testA");
        }

        int page = (11 + 10 - 1) / 10;
        System.out.println(page);
    }

    @Test
    public void testReadOneByte() throws Exception {
        File file = new File(PathUtils.getProjectPath() + File.separator + "a" + ".txt");
        FileUtil.writeString(RandomUtil.randomNumbers(10) + "_", file, "UTF-8");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        int offEct = 0;
        int index = 0;
        //for 循环方式
//        for (offEct = inputStream.read(); offEct != -1; offEct = inputStream.read()) {
//            buffer[index] = (byte) offEct;
//            index++;
//        }


        //do while 循环

//       do {
//           offEct = inputStream.read();
//           if (offEct != -1){
//               buffer[index] = (byte) offEct;
//               index++;
//           }
//       }while (offEct != -1) ;


        // while 循环
        while (true) {
            offEct = inputStream.read();
            if (offEct == -1) {
                break;
            }
            buffer[index] = (byte) offEct;
            index++;
        }

        System.out.println(new String(buffer, "UTF-8"));
        inputStream.close();
    }


    /**
     * file.length() 取得字节总数
     *
     * @throws Exception
     */
    @Test
    public void testRead() throws Exception {
        File file = new File(PathUtils.getProjectPath() + File.separator + "a" + ".txt");
        FileUtil.writeString(RandomUtil.randomNumbers(10) + "_", file, "UTF-8");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        while (inputStream.read(buffer) != -1) {
            System.out.println("finish");
        }
        System.out.println(new String(buffer, "UTF-8"));
        inputStream.close();
    }

    /**
     * file.length() 取得字节总数
     * 本方法 可以作为下面方法的解释
     *com.my_io.basic_usage.FileOutPutDemo#testCopyFile2()
     * @throws Exception
     */
    @Test
    public void testReadTwoArrayByte() throws Exception {
        //1:造数据
        File file = new File(PathUtils.getProjectPath() + File.separator + "b" + ".txt");
        String content = RandomUtil.randomNumbers(20) + "_";
        System.out.println("content:"+content);
        FileUtil.writeString(content, file, "UTF-8");
        FileInputStream inputStream = new FileInputStream(file);
        int available = inputStream.available();


        //第一个字节数组
        byte[] bytes = new byte[available/2];
        //第二个字节数组
        byte[] fileByteArray = new byte[available-bytes.length];
        inputStream.read(bytes,0,bytes.length);
        System.out.println("第一个数组装满" );
        //依旧是从0开始  读取fileByteArray个字节就行
        //将输入流中的多达字节的数据读入 字节数组
        while (inputStream.read(fileByteArray,0,fileByteArray.length) != -1){
            System.out.println("剩余数组装满" );
        }


        //将两个数组合并
        byte[] all = ArrayUtil.addAll(bytes, fileByteArray);
        System.out.println(new String(bytes, "UTF-8"));
        System.out.println(new String(fileByteArray, "UTF-8"));
        System.out.println(new String(all, "UTF-8"));
    }


    /**
     * file.length() 取得字节总数
     *
     * @throws Exception
     */
    @Test
    public void testReadArrayByte() throws Exception {
        File file = new File(PathUtils.getProjectPath() + File.separator + "a" + ".txt");
        FileUtil.writeString(RandomUtil.randomNumbers(10) + "_", file, "UTF-8");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] fileByteArray = new byte[(int) file.length()];
        //请采用本写法  java.io.FileInputStream.read(byte[], int, int)  就是这样的
        int read = inputStream.read(fileByteArray, 0, fileByteArray.length);
        System.out.println(read);
        System.out.println(new String(fileByteArray, "UTF-8"));
        inputStream.close();
    }

    /**
     * inputStream.available()  取得字节总数
     *
     * @throws Exception
     */
    @Test
    public void testReadCentOSDVD() throws Exception {
        File file = new File("D:\\data\\CentOS-7-x86_64-Minimal-2207-02.iso");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.read(buffer) != -1) {
            System.out.println("finish");
        }
        inputStream.close();
        System.out.println(buffer.length);
    }

    @Test
    public void testReadMark()throws Exception{
        File file = new File(PathUtils.getProjectPath() + File.separator + "a" + ".txt");
        String content = RandomUtil.randomNumbers(20) + "_";
        System.out.println("content:"+content);
        FileUtil.writeString(content, file, "UTF-8");
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file)) ;
        byte[] buffer = new byte[inputStream.available()];
        inputStream.skip(5);
        while (inputStream.read(buffer) != -1) {
            System.out.println("finish");
        }
        System.out.println(new String(buffer,"UTF-8"));
        inputStream.close();
    }

    @Test
    public void testReadReset()throws Exception{
        File file = new File(PathUtils.getProjectPath() + File.separator + "a" + ".txt");
        String content = RandomUtil.randomNumbers(20) + "_";
        System.out.println("content:"+content);
        FileUtil.writeString(content, file, "UTF-8");
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file)) ;
        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.read(buffer) != -1) {
            System.out.println("finish");
        }
        System.out.println(new String(buffer,"UTF-8"));


        // reset 之后可以重新读一次
        if (!inputStream.markSupported()){
            return;
        }
        inputStream.mark(0);
        inputStream.reset();
        inputStream.read(buffer,0,buffer.length) ;
        System.out.println(new String(buffer,"UTF-8"));

        inputStream.close();
    }



}
