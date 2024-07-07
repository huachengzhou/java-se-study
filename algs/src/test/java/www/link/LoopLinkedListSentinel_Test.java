package www.link;

import org.junit.Test;
import org.link.LoopLinkedListSentinel;
import org.openjdk.jol.vm.VM;

/**
 * @author : chengdu
 * @date :  2024/7/4-07
 **/
public class LoopLinkedListSentinel_Test {

    @Test
    public void test_addFirst() {
        LoopLinkedListSentinel listSentinel = new LoopLinkedListSentinel();
        listSentinel.addFirst(5D);
        listSentinel.addFirst(6D);
        listSentinel.addFirst(-7D);
        listSentinel.addFirst("sdjsdj");

        for (Object obj : listSentinel) {
            System.out.println(obj);
        }

        System.out.println("size:" + listSentinel.getSize());
    }

    @Test
    public void test_addLast() {
        LoopLinkedListSentinel listSentinel = new LoopLinkedListSentinel();
        listSentinel.addLast(5D);
        listSentinel.addLast(6D);
        listSentinel.addLast(-7D);
        listSentinel.addLast("sdjsdj");
        listSentinel.addLast("嘿嘿");
        listSentinel.forIteration(o -> System.out.println(o));
        System.out.println("size:" + listSentinel.getSize());
    }

    @Test
    public void test_insert() {
        LoopLinkedListSentinel listSentinel = new LoopLinkedListSentinel();
        listSentinel.insert(0, "asjd");
//
//        listSentinel.addLast(1);
//        listSentinel.addLast(2);
//        listSentinel.addLast(-3);
//        listSentinel.addLast("4");
//        listSentinel.addLast("5");
//
//        listSentinel.insert(4,-1);

        listSentinel.forIteration(o -> System.out.println(o));

        System.out.println("size:" + listSentinel.getSize());
    }


    @Test
    public void test_remove() {
        LoopLinkedListSentinel listSentinel = new LoopLinkedListSentinel();
        listSentinel.addLast(1);
        listSentinel.addLast(2);
        listSentinel.addLast(-3);
        listSentinel.addLast("4");
        listSentinel.addLast("树倒猢狲散");

        listSentinel.remove(0);
        listSentinel.removeLast();
        listSentinel.forIteration(o -> System.out.println(o));
        System.out.println("size:" + listSentinel.getSize());
    }

    @Test
    public void test_get() {
        LoopLinkedListSentinel listSentinel = new LoopLinkedListSentinel();
        listSentinel.addLast(1);
        listSentinel.addLast(2);
        listSentinel.addLast(-3);
        listSentinel.addLast("4");
        listSentinel.addLast("树倒猢狲散");

        System.out.println(listSentinel.get(0));
        System.out.println("size:" + listSentinel.getSize());
    }


    @Test
    public void test3() {
        String s1 = new String("s1");
        String s2 = new String("s1");
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
    }

    @Test
    public void test4() {
        String answer = "s1";
        System.out.println("The memory address is " + VM.current().addressOf(answer));
    }


}
