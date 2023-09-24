package com.my_io;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author : chengdu
 * @date :  2023/9/23-09
 **/
public class RandomAccessFileFourDemo {


    public static void main(String[] args) throws Exception {
//        String spec = "https://mirrors.tuna.tsinghua.edu.cn/centos/7/os/x86_64/Packages/389-ds-base-1.3.10.2-6.el7.x86_64.rpm";
        String spec = "";
        spec = "http://www.zhouch.life/docs/imgs/java/solr/20210721143922946.png";
        URL url = new URL(spec);
        String boundary = UUID.randomUUID().toString();
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        // 获取连接
        urlConnection.setUseCaches(false);
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();
        String fileName = getFileName(urlConnection);
        System.out.println("fileName:" + fileName);
        long contentLengthLong = urlConnection.getContentLengthLong();
        System.out.println("contentLengthLong:" + contentLengthLong);
        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
        if (!headerFields.isEmpty()) {
            headerFields.entrySet().forEach(stringListEntry -> {
                System.out.println(stringListEntry.getKey() + "_" + Arrays.asList(stringListEntry.getValue().toArray()));
            });
        }
        String input = "D:\\data\\" + UUID.randomUUID().toString().substring(0, 8) + "_" + fileName;
        System.out.println(input);
        //建立空文件
        RandomAccessFile raf = new RandomAccessFile(input, "rw");
        raf.setLength(contentLengthLong);
        raf.close();

        //开始下载文件
        InputStream read = urlConnection.getInputStream();
        int pageSize = 1024;
        long pages = contentLengthLong % pageSize == 0 ? contentLengthLong / pageSize : contentLengthLong / pageSize + 1;
        for (int i = 0; i < pages; i++) {
            byte[] bytes = new byte[ pageSize];
            int len = 0;
            if (i == pages - 1) {
                long l = contentLengthLong - i * pageSize;
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
            new FileWriteThread(off, bytes, input).start();
        }
        System.out.println("pages:" + pages);
    }

    private static String getFileName(HttpURLConnection urlConnection) throws UnsupportedEncodingException, IOException {
        int code = urlConnection.getResponseCode();
        if (code == HttpURLConnection.HTTP_OK) {
            String fileName = null;
            String headerValue = urlConnection.getHeaderField("Content-Disposition");
            if (headerValue != null && headerValue.length() > 1) {
                String[] contentDisposition = headerValue != null ? headerValue.split(";") : new String[]{};
                for (String value : contentDisposition) {
                    if (value.trim().startsWith("filename")) {
                        fileName = value.substring(value.indexOf('=') + 1).trim().replace("\"", "");
                        return fileName;
                    }
                }
            }


            // 通过Content-Disposition获取文件名
            if (fileName == null || fileName.length() < 1) {
                // 通过截取URL来获取文件名
                URL downloadUrl = urlConnection.getURL();
                // 获得实际下载文件的URL
                fileName = downloadUrl.getFile();
                fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
            } else {
                fileName = URLDecoder.decode(fileName.substring(fileName.indexOf("filename=") + 9), "UTF-8");
                // 存在文件名会被包含在""里面，所以要去掉，否则读取异常
                fileName = fileName.replaceAll("\"", "");
            }
            return fileName;
        }
        return UUID.randomUUID().toString() + ".uuid_not_found_file";
    }

    /**
     * 利用线程在文件的指定位置写入指定数据
     */
    static class FileWriteThread extends Thread {
        private int skip;
        private byte[] bytes;
        private String input;

        public FileWriteThread(int skip, byte[] bytes, String input) {
            this.skip = skip;
            this.bytes = bytes;
            this.input = input;
        }

        @Override
        public void run() {
            RandomAccessFile raf = null;
            try {
                raf = new RandomAccessFile(input, "rw");
                raf.seek(skip);
                raf.write(bytes);
                raf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
