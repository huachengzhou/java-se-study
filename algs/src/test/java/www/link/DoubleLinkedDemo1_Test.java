package www.link;

import org.junit.Test;
import org.link.DoubleLinkedDemo1;

/**
 * @author : chengdu
 * @date :  2024/6/22-06
 **/
public class DoubleLinkedDemo1_Test {


    @Test
    public void test_addFirst() {
        DoubleLinkedDemo1 linkedList = new DoubleLinkedDemo1();
        linkedList.addFirst(62);
        linkedList.addFirst(49);
        linkedList.addFirst(89);
        linkedList.addFirst(25);
        linkedList.addFirst(92);
        linkedList.addFirst(100);
        linkedList.forEach(integer -> System.out.println(integer));
    }

    @Test
    public void test_addLast() {
        DoubleLinkedDemo1 linkedList = new DoubleLinkedDemo1();
        linkedList.addLast(64);
        linkedList.addLast(98);
        linkedList.addLast(38);
        linkedList.addLast(58);
        linkedList.forEach(integer -> System.out.println(integer));
    }

    @Test
    public void test_removeFirst() {
        DoubleLinkedDemo1 linkedList = new DoubleLinkedDemo1();
        linkedList.addLast(64);
        linkedList.addLast(89);
        linkedList.removeFirst();
        linkedList.forEach(integer -> System.out.println(integer));
    }


}
