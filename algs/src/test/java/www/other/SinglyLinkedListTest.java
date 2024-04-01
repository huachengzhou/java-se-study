package www.other;

import org.ADT.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Test;

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


}
