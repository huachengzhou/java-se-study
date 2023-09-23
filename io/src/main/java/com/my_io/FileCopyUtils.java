package com.my_io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author : chengdu
 * @date :  2023/9/23-09
 **/
public class FileCopyUtils {

    /**
     * 普通文件拷贝并且加锁
     * @param source
     * @param dist
     * @throws IOException
     */
    public void fileLockCopy(File source, File dist) throws IOException {
        FileInputStream inputStream = new FileInputStream(source);
        FileOutputStream outputStream = new FileOutputStream(dist);
        FileChannel readChannel = inputStream.getChannel();
        FileChannel writeChannel = outputStream.getChannel();
        //独占锁
        FileLock fileLock = writeChannel.lock();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        while (readChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        //释放锁 必须在 outputStream 和  writeChannel 关闭之前
        fileLock.release();
        readChannel.close();
        writeChannel.close();
        inputStream.close();
        outputStream.close();
    }

    /**
     * @param source
     * @param dist
     * @throws IOException
     */
    public void accessFileCopy(File source, File dist) throws IOException {
        RandomAccessFile read = new RandomAccessFile(source, "r");
        RandomAccessFile write = new RandomAccessFile(dist, "rw");
        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        while (readChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        readChannel.close();
        writeChannel.close();
        read.close();
        write.close();
    }

    /**
     * 缓冲字节流 拷贝
     *
     * @param source
     * @param dist
     * @throws IOException
     */
    public void bufferedCopy(File source, File dist) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(dist));
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            outputStream.write(bytes);
        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 官方提供的Files工具类 copy
     *
     * @param source
     * @param dist
     * @throws IOException
     */
    public void filesCopy(File source, File dist) throws IOException {
        Files.copy(source.toPath(), dist.toPath());
    }


    /**
     * 通道 transferFrom
     *
     * @param source
     * @param dist
     * @throws IOException
     */
    public void channelTransferFromCopy(File source, File dist) throws IOException {
        FileInputStream inputStream = new FileInputStream(source);
        FileOutputStream outputStream = new FileOutputStream(dist, false);
        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();
        outChannel.transferFrom(inChannel, 0, inChannel.size());
        inChannel.close();
        inputStream.close();
        outChannel.close();
        outputStream.close();
    }

    /**
     * 通道 transferTo
     *
     * @param source
     * @param dist
     * @throws IOException
     */
    public void channelTransferToCopy(File source, File dist) throws IOException {
        FileInputStream inputStream = new FileInputStream(source);
        FileOutputStream outputStream = new FileOutputStream(dist, false);
        //             G   MB     KB     B
        long maxSize = 2L * 1024L * 1024L * 1024L;
        if (source.length() > maxSize) {
            throw new IOException("transferTo is max 2G");
        }
        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();
        inChannel.transferTo(0, inChannel.size(), outChannel);
        inChannel.close();
        inputStream.close();
        outChannel.close();
        outputStream.close();
    }


    /**
     * 缓冲区拷贝
     * 适合 文件超大的情况
     *
     * @param source
     * @param dist
     * @throws IOException
     */
    public void channelBufferCopy(File source, File dist) throws IOException {
        FileInputStream inputStream = new FileInputStream(source);
        FileOutputStream outputStream = new FileOutputStream(dist, false);
        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        while (inChannel.read(byteBuffer) != -1) {
            //不管读写都要用flip标记limit位置
            byteBuffer.flip();
            /* 把缓冲区的内容写入输出文件中 */
            outChannel.write(byteBuffer);
            /* 清空缓冲区 */
            byteBuffer.clear();
        }
        inChannel.close();
        inputStream.close();
        outChannel.close();
        outputStream.close();
    }

    /**
     * 内存映射拷贝 适合文件较小并且内存充足
     * 速度极快
     *
     * @param source
     * @param dist
     * @throws IOException
     */
    public void memoryCopy(File source, File dist) throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get(source.getPath()), StandardOpenOption.READ);
        //这里为什么加 StandardOpenOption.READ 是因为outMapped需要读取写通道的缓存
        FileChannel outChannel = FileChannel.open(Paths.get(dist.getPath()), StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        /**
         * 内存映射文件
         * 这种方式缓冲区是直接建立在物理内存之上的
         * 所以我们就不需要通道了
         */
        MappedByteBuffer inMapped = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        //READ_WRITE 读写
        MappedByteBuffer outMapped = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        byte[] buffer = new byte[inMapped.limit()];
        //将内存映射文件丢到字节数组中
        inMapped.get(buffer);
        //将字节数组  丢到 写内存映射文件
        outMapped.put(buffer);
        inChannel.close();
        outChannel.close();
    }


}
