package www.other;

import com.google.common.collect.Lists;
import org.ADT.SinglyLinkedListSentinel_1;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.Assertion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : chengdu
 * @date :  2024/5/2-05
 **/
public class SinglyLinkedListSentinel_1Test {

    @Test
    public void test_addFirst() {
        SinglyLinkedListSentinel_1 singlyLinkedList = new SinglyLinkedListSentinel_1();
        singlyLinkedList.addFirst(2);//第一次 第一个元素 第二次 第二个元素
        singlyLinkedList.addFirst(3);//               第二次 第一个元素
        Assert.assertTrue("元素个数不相等", 2 == singlyLinkedList.getSize());
        Assert.assertTrue("元素不相等", 3 == singlyLinkedList.get(0));
    }

    @Test
    public void test_loop() {
        SinglyLinkedListSentinel_1 singlyLinkedList = new SinglyLinkedListSentinel_1();
        singlyLinkedList.addFirst(2);//第一次 第一个元素 第二次 第二个元素  第三次 第三个元素
        singlyLinkedList.addFirst(3);//               第二次 第一个元素  第三次 第二个元素
        singlyLinkedList.addFirst(1);//                               第三次 第一个元素
        singlyLinkedList.loop(obj -> System.out.println(obj));
    }

    @Test
    public void test_loopFor() {
        SinglyLinkedListSentinel_1 singlyLinkedList = new SinglyLinkedListSentinel_1();
        singlyLinkedList.addFirst(5);//第一次 第一个元素 第二次 第二个元素  第三次 第三个元素
        singlyLinkedList.addFirst(2);//               第二次 第一个元素  第三次 第二个元素
        singlyLinkedList.addFirst(3);//                               第三次 第一个元素
        singlyLinkedList.loopFor(obj -> System.out.println(obj));
    }

    @Test
    public void test_stream() {
        SinglyLinkedListSentinel_1 singlyLinkedList = new SinglyLinkedListSentinel_1();
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        singlyLinkedList.stream().forEach(integer -> System.out.println(integer));
    }

    @Test
    public void test_iterator() {
        SinglyLinkedListSentinel_1 singlyLinkedList = new SinglyLinkedListSentinel_1();
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        for (Integer integer : singlyLinkedList) {
            System.out.println(integer);
        }
    }


    @Test
    public void test_addLast() {
        SinglyLinkedListSentinel_1 singlyLinkedList = new SinglyLinkedListSentinel_1();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        Assertion assertion = new Assertion();
        assertion.assertEquals(singlyLinkedList.stream().collect(Collectors.toList()), Lists.newArrayList(1, 2, 3, 4));
        singlyLinkedList.forEach(integer -> System.out.println(integer));
    }

    @Test
    public void test_get() {
        SinglyLinkedListSentinel_1 singlyLinkedList = new SinglyLinkedListSentinel_1();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        int v = singlyLinkedList.get(3);
        Assert.assertTrue("不相等!", 4 == v);
    }

    @Test
    public void test_insert() {
        SinglyLinkedListSentinel_1 singlyLinkedList = new SinglyLinkedListSentinel_1();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.insert(4, 0);
        for (Integer integer : singlyLinkedList) {
            System.out.println(integer);
        }
    }


    @Test
    public void test_removeFirst() {
        SinglyLinkedListSentinel_1 singlyLinkedList = new SinglyLinkedListSentinel_1();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.removeFirst();
        singlyLinkedList.removeFirst();
//        singlyLinkedList.removeFirst();
//        singlyLinkedList.removeFirst();
        for (Integer integer : singlyLinkedList) {
            System.out.println(integer);
        }
    }

    @Test
    public void test_remove() {
        SinglyLinkedListSentinel_1 singlyLinkedList = new SinglyLinkedListSentinel_1();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        singlyLinkedList.addLast(5);

        singlyLinkedList.remove(0);
        singlyLinkedList.remove(singlyLinkedList.getSize() - 1);
        for (Integer integer : singlyLinkedList) {
            System.out.println(integer);
        }
    }


    @Test
    public void testMulReadFileLine() throws Exception {
        String dir = "E:\\data\\sql\\pmcc_acc_all.sql";
        File file = new File(dir);
        System.out.println("length:" + file.length());
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int size = 200;
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
            size--;
            if (size == 0) {
                break;
            }
        }
    }


}
