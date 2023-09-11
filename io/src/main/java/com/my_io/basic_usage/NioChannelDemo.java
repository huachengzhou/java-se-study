package com.my_io.basic_usage;

import cn.hutool.core.util.RandomUtil;
import com.my_io.PathUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author : chengdu
 * @date :  2023/9/10-09
 **/
public class NioChannelDemo {

    /**
     * 创建通道
     *
     * @throws Exception
     */
    @Test
    public void testCreateChannel() throws Exception {
        //结果是创建了一个空的新文件  注意不要直接留一个 StandardOpenOption.CREATE 除非文件存在
        String path = PathUtils.getProjectPath() + File.separator + "create_channel_z" + ".txt";
        FileChannel fileChannel = FileChannel.open(Paths.get(path), StandardOpenOption.CREATE, StandardOpenOption.WRITE);


        //下面这个文件存在  是不会报错的
//        String path = PathUtils.getProjectPath() + File.separator + "create_channel" + ".txt";
//        FileChannel fileChannel = FileChannel.open(Paths.get(path),  StandardOpenOption.CREATE);


//        fileChannel.close();
    }

    /**
     * 操作通道写文件
     *
     * @throws Exception
     */
    @Test
    public void testWriteChannel() throws Exception {
        String content = RandomUtil.randomNumbers(20) + "_";
        byte[] bytes = content.getBytes("UTF-8");
        System.out.println("content:" + content);
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();


        String path = PathUtils.getProjectPath() + File.separator + "create_channel" + ".txt";
        FileChannel fileChannel = FileChannel.open(Paths.get(path), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        fileChannel.write(byteBuffer);
        // 将数据刷出到磁盘
        fileChannel.force(false);
        fileChannel.close();
    }


    /**
     * 操作通道读文件
     *
     * @throws Exception
     */
    @Test
    public void testReadChannel() throws Exception {
        testWriteChannel();

        String path = PathUtils.getProjectPath() + File.separator + "create_channel" + ".txt";
        FileChannel fileChannel = FileChannel.open(Paths.get(path), StandardOpenOption.READ);
        System.out.println(fileChannel.size());
        System.out.println(fileChannel.position());
        System.out.println();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
        //将通道内容读到缓冲区
        fileChannel.read(byteBuffer);
        //将缓冲区切换为读模式
        byteBuffer.flip();
        printByteBuffer(byteBuffer);

        byte[] byteArray = new byte[byteBuffer.limit()];
        byteBuffer.get(byteArray);
        System.out.println(new String(byteArray));
        printByteBuffer(byteBuffer);
    }

    /**
     * 直接缓冲区 读写
     * @throws Exception
     */
    @Test
    public void testReadWriteChannel() throws Exception {
        File file = new File("D:\\data\\Google Java 编程风格指南.xmind");
        File copyFile = new File("D:\\data\\Google_Java_编程风格指南" + RandomUtil.randomNumbers(8) + ".xmind");
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(copyFile, false);
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
     * 使用内存映射
     * @throws Exception
     */
    @Test
    public void testReadWriteMemoryChannel() throws Exception {
        File file = new File("D:\\data\\Google Java 编程风格指南.xmind");
        File copyFile = new File("D:\\data\\Google_Java_编程风格指南" + RandomUtil.randomNumbers(8) + ".xmind");


        FileChannel inChannel = FileChannel.open(Paths.get(file.getPath()),StandardOpenOption.READ);
        //这里为什么加 StandardOpenOption.READ 是因为outMapped需要读取写通道的缓存
        FileChannel outChannel = FileChannel.open(Paths.get(copyFile.getPath()),StandardOpenOption.READ,StandardOpenOption.CREATE,StandardOpenOption.WRITE);

        /**
         * 内存映射文件
         * 这种方式缓冲区是直接建立在物理内存之上的
         * 所以我们就不需要通道了
         */
        MappedByteBuffer inMapped = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        //READ_WRITE 读写
        MappedByteBuffer outMapped = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] buffer = new byte[inMapped.limit()] ;
        //将内存映射文件丢到字节数组中
        inMapped.get(buffer);

        //将字节数组  丢到 写内存映射文件
        outMapped.put(buffer);

        inChannel.close();
        outChannel.close();
    }

    /**
     * 打印 ByteBuffer
     *
     * @param byteBuffer
     */
    private void printByteBuffer(ByteBuffer byteBuffer) {
        System.out.println("容量:" + byteBuffer.capacity());
        System.out.println("操作数据最大界限:" + byteBuffer.limit());
        System.out.println("正在操作数据的位置:" + byteBuffer.position());
        System.out.println("记录当前 position 的位置:" + byteBuffer.mark());
        System.out.println();
    }


}
