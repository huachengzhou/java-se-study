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

    @Test
    public void test_remove() {
        DoubleLinkedDemo1 linkedList = new DoubleLinkedDemo1();
        linkedList.addLast(41);
        linkedList.addLast(84);
        linkedList.addLast(46);
        linkedList.addLast(59);

        linkedList.remove(3);
        linkedList.forEach(integer -> System.out.println(integer));
    }


    @Test
    public void test_insert() {
        DoubleLinkedDemo1 linkedList = new DoubleLinkedDemo1();
        linkedList.insert(92, 0);
        linkedList.insert(88, 1);
        linkedList.insert(100, 2);
        linkedList.insert(29, 3);
//        linkedList.forEach(integer -> System.out.println(integer));

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(3));
    }

}
