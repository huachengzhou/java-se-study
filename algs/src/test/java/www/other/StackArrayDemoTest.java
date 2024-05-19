package www.other;

import org.StackArrayDemo;
import org.junit.Test;

/**
 * @author : chengdu
 * @date :  2024/5/19-05
 **/
public class StackArrayDemoTest {

    @Test
    public void test_push() {
        StackArrayDemo stackArrayDemo = new StackArrayDemo(10);
        stackArrayDemo.push(2);
        stackArrayDemo.push(3);
        stackArrayDemo.loop(o -> System.out.println(o));
    }

    @Test
    public void test_pop() {
        StackArrayDemo stackArrayDemo = new StackArrayDemo(10);
        stackArrayDemo.push(3);
        stackArrayDemo.push(7);
        System.out.println(stackArrayDemo.pop());
        System.out.println(stackArrayDemo.pop());
        System.out.println(stackArrayDemo.pop());
    }


    @Test
    public void test1() {
        int[] arr = new int[]{3, 6};
        System.out.println(arr.length);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
