package www.other;

import com.google.common.collect.Lists;
import org.ADT.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.Assertion;

import java.util.stream.Collectors;


/**
 * @author : chengdu
 * @date :  2024/4/1-04
 **/
public class SinglyLinkedListTest {

    @Test
    public void test_addFirst() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(2);//第一次 第一个元素 第二次 第二个元素
        singlyLinkedList.addFirst(3);//               第二次 第一个元素
        Assert.assertTrue("元素个数不相等", 2 == singlyLinkedList.getSize());
    }

    @Test
    public void test_loop() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(2);//第一次 第一个元素 第二次 第二个元素  第三次 第三个元素
        singlyLinkedList.addFirst(3);//               第二次 第一个元素  第三次 第二个元素
        singlyLinkedList.addFirst(1);//                               第三次 第一个元素
        singlyLinkedList.loop(obj -> System.out.println(obj));
    }

    @Test
    public void test_loopFor() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(5);//第一次 第一个元素 第二次 第二个元素  第三次 第三个元素
        singlyLinkedList.addFirst(2);//               第二次 第一个元素  第三次 第二个元素
        singlyLinkedList.addFirst(3);//                               第三次 第一个元素
        singlyLinkedList.loopFor(obj -> System.out.println(obj));
    }

    @Test
    public void test_stream() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        singlyLinkedList.addFirst((int) Math.round(Math.random() * 100));
        singlyLinkedList.stream().forEach(integer -> System.out.println(integer));
    }

    @Test
    public void test_iterator() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
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
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        Assertion assertion = new Assertion();
        assertion.assertEquals(singlyLinkedList.stream().collect(Collectors.toList()), Lists.newArrayList(1, 2, 3, 4));
    }

    @Test
    public void test_get() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        Assert.assertTrue("不相等!", 3 == singlyLinkedList.get(2));
    }

    @Test
    public void test_insert() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.insert(4,1);
        for (Integer integer:singlyLinkedList){
            System.out.println(integer);
        }
    }


}
