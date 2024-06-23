package www.link;

import org.junit.Test;
import org.link.SinglyLinkedDemo1;

/**
 * 单链表 (非哨兵模式)
 *
 * @author : chengdu
 * @date :  2024/6/22-06
 **/
public class SinglyLinkedDemo1Test {

    @Test
    public void test_addFirst() {
        SinglyLinkedDemo1 singlyLinkedDemo1 = new SinglyLinkedDemo1();
        singlyLinkedDemo1.addFirst(6);
        singlyLinkedDemo1.addFirst(9);
        singlyLinkedDemo1.addFirst(3);
        singlyLinkedDemo1.addFirst(7);
        System.out.println(singlyLinkedDemo1.peekFirst());
    }

    @Test
    public void test_addLast() {
        SinglyLinkedDemo1 singlyLinkedDemo1 = new SinglyLinkedDemo1();
        singlyLinkedDemo1.addLast(8);
        singlyLinkedDemo1.addLast(7);
        singlyLinkedDemo1.addLast(11);
        singlyLinkedDemo1.addLast(13);
        singlyLinkedDemo1.addLast(20);
        singlyLinkedDemo1.loop(integer -> System.out.println(integer));
    }


    @Test
    public void test_removeFirst() {
        SinglyLinkedDemo1 singlyLinkedDemo1 = new SinglyLinkedDemo1();
        singlyLinkedDemo1.addLast(8);
        singlyLinkedDemo1.addLast(13);
        singlyLinkedDemo1.addLast(50);
        singlyLinkedDemo1.addLast(99);
        singlyLinkedDemo1.loop(integer -> System.out.println(integer));
        singlyLinkedDemo1.removeFirst();
        System.out.println("-----------------------------------------------------------------------------------");
        singlyLinkedDemo1.loop(integer -> System.out.println(integer));
        singlyLinkedDemo1.removeFirst();
        singlyLinkedDemo1.removeFirst();
        singlyLinkedDemo1.removeFirst();
        System.out.println("-----------------------------------------------------------------------------------");
        singlyLinkedDemo1.loop(integer -> System.out.println(integer));
        singlyLinkedDemo1.removeFirst();
    }

    @Test
    public void test_remove() {
        SinglyLinkedDemo1 singlyLinkedDemo1 = new SinglyLinkedDemo1();

        singlyLinkedDemo1.addLast(51);
        singlyLinkedDemo1.addLast(11);
        singlyLinkedDemo1.addLast(72);
        singlyLinkedDemo1.addLast(25);
        singlyLinkedDemo1.remove(8);
        System.out.println("-----------------------------------------------------------------------------------");
        singlyLinkedDemo1.loop(integer -> System.out.println(integer));
    }

    @Test
    public void test_insert() {
        SinglyLinkedDemo1 singlyLinkedDemo1 = new SinglyLinkedDemo1();

        singlyLinkedDemo1.addFirst(66);
        singlyLinkedDemo1.addFirst(69);
        singlyLinkedDemo1.addFirst(1);
        singlyLinkedDemo1.addFirst(44);

        System.out.println("-----------------------------------------------------------------------------------");
        singlyLinkedDemo1.loop(integer -> System.out.println(integer));
        System.out.println("-----------------------------------------------------------------------------------");
        singlyLinkedDemo1.insert(32,3);
        singlyLinkedDemo1.loop(integer -> System.out.println(integer));
    }

    @Test
    public void test_get() {
        SinglyLinkedDemo1 singlyLinkedDemo1 = new SinglyLinkedDemo1();

        singlyLinkedDemo1.addFirst(94);
        singlyLinkedDemo1.addFirst(41);
        singlyLinkedDemo1.addFirst(65);
        singlyLinkedDemo1.addFirst(64);
        singlyLinkedDemo1.addFirst(12);
        singlyLinkedDemo1.addFirst(86);

        singlyLinkedDemo1.forEach(integer -> System.out.println(integer));
        System.out.println("元素获取:"+singlyLinkedDemo1.get(3));
        System.out.println("元素个数:"+singlyLinkedDemo1.getSize());
    }

}
