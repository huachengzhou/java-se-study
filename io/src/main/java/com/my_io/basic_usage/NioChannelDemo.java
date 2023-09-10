package com.my_io.basic_usage;

import cn.hutool.core.util.RandomUtil;
import com.my_io.PathUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
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
     * @throws Exception
     */
    @Test
    public void testCreateChannel()throws Exception{
        //结果是创建了一个空的新文件  注意不要直接留一个 StandardOpenOption.CREATE 除非文件存在
        String path = PathUtils.getProjectPath() + File.separator + "create_channel_z" + ".txt";
        FileChannel fileChannel = FileChannel.open(Paths.get(path),  StandardOpenOption.CREATE,StandardOpenOption.WRITE);


        //下面这个文件存在  是不会报错的
//        String path = PathUtils.getProjectPath() + File.separator + "create_channel" + ".txt";
//        FileChannel fileChannel = FileChannel.open(Paths.get(path),  StandardOpenOption.CREATE);


//        fileChannel.close();
    }

    /**
     * 操作通道写文件
     * @throws Exception
     */
    @Test
    public void testWriteChannel()throws Exception{
        String content = RandomUtil.randomNumbers(20) + "_";
        byte[] bytes = content.getBytes("UTF-8");
        System.out.println("content:"+content);
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();


        String path = PathUtils.getProjectPath() + File.separator + "create_channel" + ".txt";
        FileChannel fileChannel = FileChannel.open(Paths.get(path), StandardOpenOption.WRITE);
        fileChannel.write(byteBuffer);
        // 将数据刷出到磁盘
        fileChannel.force(false);
        fileChannel.close();
    }


    /**
     * 操作通道读文件
     * @throws Exception
     */
    @Test
    public void testReadChannel()throws Exception{
        String path = PathUtils.getProjectPath() + File.separator + "create_channel" + ".txt";
        FileChannel fileChannel = FileChannel.open(Paths.get(path), StandardOpenOption.READ);
        System.out.println(fileChannel.size());
        System.out.println(fileChannel.position());
        System.out.println();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int)fileChannel.size());
        //将通道内容读到缓冲区
        fileChannel.read(byteBuffer) ;
        //将缓冲区切换为读模式
        byteBuffer.flip();
        printByteBuffer(byteBuffer);

        byte[] byteArray = new byte[byteBuffer.limit()];
        byteBuffer.get(byteArray);
        System.out.println(new String(byteArray));
        printByteBuffer(byteBuffer);
    }

    @Test
    public void testReadWriteChannel()throws Exception{

    }

    /**
     * 打印 ByteBuffer
     * @param byteBuffer
     */
    private void printByteBuffer(ByteBuffer byteBuffer) {
        System.out.println("容量:" + byteBuffer.capacity());
        System.out.println("操作数据最大界限:" + byteBuffer.limit());
        System.out.println("正在操作数据的位置:" + byteBuffer.position());
        System.out.println("记录当前 position 的位置:" + byteBuffer.mark());
        System.out.println();
    }

    public static void fastCopy(String src, String dist) throws IOException {

        /* 获得源文件的输入字节流 */
        FileInputStream fin = new FileInputStream(src);

        /* 获取输入字节流的文件通道 */
        FileChannel fcin = fin.getChannel();

        /* 获取目标文件的输出字节流 */
        FileOutputStream fout = new FileOutputStream(dist);

        /* 获取输出字节流的通道 */
        FileChannel fcout = fout.getChannel();

        /* 为缓冲区分配 1024 个字节 */
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {

            /* 从输入通道中读取数据到缓冲区中 */
            int r = fcin.read(buffer);

            /* read() 返回 -1 表示 EOF */
            if (r == -1) {
                break;
            }

            /* 切换读写 */
            buffer.flip();

            /* 把缓冲区的内容写入输出文件中 */
            fcout.write(buffer);

            /* 清空缓冲区 */
            buffer.clear();
        }
    }


}
