package com.my_io;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author : chengdu
 * @date :  2023/9/23-09
 **/
public class RandomAccessFileThreeDemo {

    private static final String SOURCE_PATH = "D:\\data\\Google Java 编程风格指南.xmind";
    private static final String INPUT_PATH = "D:\\data\\" + UUID.randomUUID().toString() + "Google_Java_编程风格指南.xmind";

    public static void main(String[] args) throws Exception {
        // 预分配文件所占的磁盘空间，磁盘中会创建一个指定大小的文件
        File source = new File(SOURCE_PATH);
        RandomAccessFile raf = new RandomAccessFile(INPUT_PATH, "rw");
        long newLength = source.length();
        raf.setLength(newLength);
        raf.close();


        RandomAccessFile read = new RandomAccessFile(SOURCE_PATH, "r");
        int pageSize = 1024;
        long pages = newLength % pageSize == 0 ? newLength / pageSize : newLength / pageSize + 1;
        for (int i = 0; i < pages; i++) {
            byte[] bytes = new byte[pageSize];
            int len = 0;
            if (i == pages - 1) {
                long l = newLength - i * pageSize;
                len = (int) l;
            } else {
                len = pageSize;
            }
            int off = i * pageSize;
            read.read(bytes, 0, len);
            if (len != pageSize) {
                //最后一段的时候  字节大小强行把多余的截断
                bytes = Arrays.copyOfRange(bytes, 0, len);
            }
            // 利用多线程同时写入一个文件
            new FileWriteThread(off, bytes).start();
            System.out.println(i);
        }
        System.out.println("pages:" + pages);


    }

    /**
     * 利用线程在文件的指定位置写入指定数据
     */
    static class FileWriteThread extends Thread {
        private int skip;
        private byte[] bytes;

        public FileWriteThread(int skip, byte[] bytes) {
            this.skip = skip;
            this.bytes = bytes;
        }

        @Override
        public void run() {
            RandomAccessFile raf = null;
            try {
                raf = new RandomAccessFile(INPUT_PATH, "rw");
                raf.seek(skip);
                raf.write(bytes);
                raf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
