package www.link;

import org.junit.Test;
import org.link.DoublyLinkedListSentinel;

/**
 * @author : chengdu
 * @date :  2024/7/4-07
 **/
public class DoublyLinkedListSentinel_Test {

    @Test
    public void test_addFirst(){
        DoublyLinkedListSentinel listSentinel = new DoublyLinkedListSentinel();
        listSentinel.addFirst(5D);
        listSentinel.addFirst(6D);
        listSentinel.addFirst(-7D);


        listSentinel.loop(d -> System.out.println(d));

    }


}
