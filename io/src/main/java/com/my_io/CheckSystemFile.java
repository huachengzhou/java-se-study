package com.my_io;

import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.io.File;
import java.text.DecimalFormat;

/**
 * @author : chengdu
 * @date :  2023/9/16-09
 **/
public class CheckSystemFile {

    @Test
    public void test_print_c() {
//        String dir = "C:\\";
        String dir = "C:\\Users";
        File parent = new File(dir);
        File[] files = parent.listFiles();
        for (File fFile : files) {
            new Thread(() -> {
                long size = FileUtil.size(fFile);
                if (size == 0) {
                    return;
                }
                System.out.println("file:" + fFile + " ; size:" + formatFileSize(size));
            }).start();
        }
        try {
            Thread.sleep(1000 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test_print_users() {
        String dir = "C:\\Users\\noatn";
        File parent = new File(dir);
        File[] files = parent.listFiles();
        for (File fFile : files) {
            new Thread(() -> {
                long size = FileUtil.size(fFile);
                if (size == 0) {
                    return;
                }
                System.out.println("file:" + fFile + " ; size:" + formatFileSize(size));
            }).start();
        }
        try {
            Thread.sleep(1000 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 格式化文件大小
     *
     * @param fileLength 单位b
     * @return
     */
    private static String formatFileSize(Long fileLength) {
        String fileSizeString = "";
        if (fileLength == null) {
            return fileSizeString;
        }
        DecimalFormat df = new DecimalFormat("#.00");
        if (fileLength < 1024) {
            fileSizeString = df.format((double) fileLength) + "B";
        } else if (fileLength < 1048576) {
            fileSizeString = df.format((double) fileLength / 1024) + "K";
        } else if (fileLength < 1073741824) {
            fileSizeString = df.format((double) fileLength / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileLength / 1073741824) + "G";
        }
        return fileSizeString;
    }


}
