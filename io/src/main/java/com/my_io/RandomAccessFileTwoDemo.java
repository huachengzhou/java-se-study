package com.my_io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : chengdu
 * @date :  2023/9/23-09
 **/
public class RandomAccessFileTwoDemo {

    private static final String D_ABC_TXT = "D:\\data\\abc_2.txt";
    public static final String UTF_8 = "UTF-8";

    public static void main(String[] args) throws Exception {
        // 预分配文件所占的磁盘空间，磁盘中会创建一个指定大小的文件
        RandomAccessFile raf = new RandomAccessFile(D_ABC_TXT, "rw");
        List<String> stringList = new LinkedList<>();

        stringList.add("往往在逃避命运的路上,却与之不期而遇");
        stringList.add("你的思想就如同水,我的朋友,当水波摇曳时,很难看清,不过当它平静下来,答案就清澈见底了");
        stringList.add("退出，不退出。做面条，不做面条。");
        stringList.add("过去的,已经过去了;未来的,还未可知;现在,却是上苍的礼赠;那就是为什么今天是present(现在/礼物)");

        stringList.add("124");
        stringList.add("321");
        stringList.add("zcf");
        long newLength = 0;
        int[] arr = new int[stringList.size()];
        for (int i = 0; i < arr.length; i++) {
            int length = stringList.get(i).getBytes(UTF_8).length;
            arr[i] = length;
            newLength += length;
        }
        raf.setLength(newLength);
        raf.close();

        int startSize = 0;
        for (String str : stringList) {
            // 利用多线程同时写入一个文件
            new FileWriteThread(startSize, str).start();
            startSize += str.getBytes(UTF_8).length;
        }


    }

    /**
     * 利用线程在文件的指定位置写入指定数据
     */
    static class FileWriteThread extends Thread {
        private int skip;
        private String content;

        public FileWriteThread(int skip, String content) {
            this.skip = skip;
            this.content = content;
        }

        @Override
        public void run() {
            RandomAccessFile raf = null;
            try {
                raf = new RandomAccessFile(D_ABC_TXT, "rw");
                raf.seek(skip);
                raf.write(content.getBytes(UTF_8));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    raf.close();
                } catch (Exception e) {
                }
            }
        }
    }

}
