package com.my_io.basic_usage;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author : chengdu
 * @date :  2023/9/10-09
 **/
public class NioBufferDemo {
    private static final String UTF_8 = "UTF-8";

    //https://zhuanlan.zhihu.com/p/369062109
    //https://zhuanlan.zhihu.com/p/522022419


    /*
    capacity: 容量，表示缓冲区中最大存储数据的容量。一旦声明不能更改。
    limit: 界限，表示缓冲区中可以操作数据的大小。（limit 后的数据不能进行读写）
    position: 位置，表示缓冲区中正在操作数据的位置。 实际不管读写都会移动
    mark: 标记，表示记录当前 position 的位置。可以通过 reset() 恢复到 mark 的位置
    * */


    /**
     * 创建缓冲区
     */
    @Test
    public void testCreateBuffer()throws Exception {

        //非直接缓冲区
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        printByteBuffer(byteBuffer);

        //直接缓冲区 通过 allocateDirect() 方法分配缓冲区，将缓冲区建立在物理内存之中
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        printByteBuffer(byteBuffer);
    }

    /**
     * 切换到读数据模式
     * @throws Exception
     */
    @Test
    public void testFlipBuffer()throws Exception {
        /*
        flip方法将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，并将limit设置成之前position的值。

        换句话说，position现在用于标记读的位置，limit表示之前写进了多少个byte、char等 —— 现在能读取多少个byte、char等。
        * */
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        printByteBuffer(byteBuffer);

        //填充一个字节数据
        byteBuffer.put("abc".getBytes(UTF_8));
        printByteBuffer(byteBuffer);

        //切换到读数据模式
        byteBuffer.flip();
        printByteBuffer(byteBuffer);
    }

    /**
     * 获取缓冲区数据
     */
    @Test
    public void testGetBuffer()throws Exception{
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        printByteBuffer(byteBuffer);

        //填充一个字节数据
        byteBuffer.put("abcdef".getBytes(UTF_8));
        printByteBuffer(byteBuffer);

        //切换到读数据模式 实际是切换读写 因为不管读和写都是这个方法
        /*
        flip方法将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，并将limit设置成之前position的值。
        换句话说，position现在用于标记读的位置，limit表示之前写进了多少个byte、char等 —— 现在能读取多少个byte、char等。
        * */
        byteBuffer.flip();
//        byteBuffer.limit(byteBuffer.position());
//        byteBuffer.position(0);
        printByteBuffer(byteBuffer);

        byte[] bytes = new byte[byteBuffer.limit()] ;

        byteBuffer.get(bytes,0,bytes.length);
        System.out.println(new String(bytes,UTF_8));
        System.out.println();

        printByteBuffer(byteBuffer);
    }

    /**
     * 可重复读
     * @throws Exception
     */
    @Test
    public void testRewindBuffer()throws Exception{
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //填充一个字节数据
        byteBuffer.put("你好!".getBytes(UTF_8));

        //切换到读数据模式
        /*
        flip方法将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，并将limit设置成之前position的值。
        换句话说，position现在用于标记读的位置，limit表示之前写进了多少个byte、char等 —— 现在能读取多少个byte、char等。
        * */
        byteBuffer.flip();
        printByteBuffer(byteBuffer);

        byte[] bytes = new byte[byteBuffer.limit()] ;

        byteBuffer.get(bytes,0,bytes.length);
        System.out.println(new String(bytes,UTF_8));

        //这个方法调用完后,又变成了读模式
        byteBuffer.rewind();
        printByteBuffer(byteBuffer);

        byte[] buffer = new byte[byteBuffer.limit()] ;

        byteBuffer.get(buffer,0,buffer.length);
        System.out.println(new String(buffer,UTF_8));

    }

    /**
     * 清空缓冲区
     * @throws Exception
     */
    @Test
    public void testClearBuffer()throws Exception{
      /*
      clear() 清空缓冲区,虽然缓冲区被清空了，但是缓冲区中的数据依然存在，只是出于"被遗忘"状态。
      意思其实是，缓冲区中的界限、位置等信息都被置为最初的状态了，所以你无法再根据这些信息找到原来的数据了，
      原来数据就出于"被遗忘"状态
       * */
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //填充一个字节数据
        byteBuffer.put("你好!".getBytes(UTF_8));
        printByteBuffer(byteBuffer);
        byteBuffer.clear();
        printByteBuffer(byteBuffer);
    }

    @Test
    public void test_mark_reset()throws Exception{
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //填充一个字节数据
        byteBuffer.put("影响我们人生的绝不仅仅是环境，其实是心态在控制个人的行动和思想。同时，心态也决定了一个人的视野、事业和成就，甚至一生!".getBytes(UTF_8));
        byteBuffer.flip();
        byte[] byteArray = new byte[byteBuffer.limit()];
        byteBuffer.get(byteArray,0,20);
        printByteBuffer(byteBuffer);
        System.out.println(new String(byteArray,UTF_8));
        byteBuffer.mark();//标记此时position索引位置


        byteBuffer.get(byteArray,20,20);
        printByteBuffer(byteBuffer);
        System.out.println(new String(byteArray,UTF_8));

        byteBuffer.reset();
        byteBuffer.get(byteArray,0,20);
        printByteBuffer(byteBuffer);
        System.out.println(new String(byteArray,UTF_8));

        //判断缓冲区中是否还有剩余数据
        if (byteBuffer.hasRemaining()) {
            //获取缓冲区中可以操作的数量
            System.out.println(byteBuffer.remaining());
            //结果是 115
        }

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



}
