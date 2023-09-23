package com.my_io;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : chengdu
 * @date :  2023/9/23-09
 **/
public class RandomAccessFileFour2Demo {


    public static void main(String[] args) throws Exception {
//        String spec = "https://mirrors.tuna.tsinghua.edu.cn/centos/7/os/x86_64/Packages/389-ds-base-1.3.10.2-6.el7.x86_64.rpm";
        String spec = "";
        spec = "https://qiniu-cdn0.jinxidao.com/group1/M00/48/7B/oYYBAF8zWOCAdzRlAAb5EeegLnw937.jpg";
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
        //建立空文件
        RandomAccessFile raf = new RandomAccessFile(input, "rw");
        raf.setLength(contentLengthLong);
        raf.close();

        //开始下载文件
        InputStream read = urlConnection.getInputStream();
        int pageSize = 1024 * 2;
        long pages = contentLengthLong % pageSize == 0 ? contentLengthLong / pageSize : contentLengthLong / pageSize + 1;
        CountDownLatch downLatch = null;
        int count = 1;
        //利用多线程分段下载
        for (long i = 0L; i < pages; i++) {
            //线程分组
            long groupIndex = 10;
            if (i % groupIndex == 0) {
                System.out.println("第" + count + "次分组分段下载!");
                if (i == 0L) {
                    downLatch = new CountDownLatch((int) groupIndex);
                }
                if (i + groupIndex > pages) {
                    groupIndex = pages - i;
                }
                if (i != 0L) {
                    downLatch.await();
                    downLatch = new CountDownLatch((int) groupIndex);
                }
                count++;
            }
            byte[] bytes = new byte[pageSize];
            int len = 0;
            if (i == pages - 1) {
                long l = contentLengthLong - i * pageSize;
                len = (int) l;
            } else {
                len = pageSize;
            }
            long off = i * pageSize;
            read.read(bytes, 0, len);
            if (len != pageSize) {
                //最后一段的时候  字节大小强行把多余的截断
                bytes = Arrays.copyOfRange(bytes, 0, len);
            }
            // 利用多线程同时写入一个文件
            new FileWriteThread(off, bytes, input, downLatch).start();
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
        private long skip;
        private byte[] bytes;
        private String input;
        private CountDownLatch downLatch;

        public FileWriteThread(long skip, byte[] bytes, String input, CountDownLatch downLatch) {
            this.skip = skip;
            this.bytes = bytes;
            this.input = input;
            this.downLatch = downLatch;
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
            } finally {
                downLatch.countDown();
            }
        }
    }

    /**
     * 使用流遍历操作
     *
     * @param list
     * @param size
     * @param <T>
     * @return
     */
    private static <T> List<List<T>> partition(final List<T> list, final int size) {
        Integer limit = (list.size() + size - 1) / size;
        List<List<T>> mglist = new ArrayList<List<T>>();
        Stream.iterate(0, n -> n + 1).limit(limit).forEach(i -> {
            mglist.add(list.stream().skip(i * size).limit(size).collect(Collectors.toList()));
        });
        return mglist;
    }

}
