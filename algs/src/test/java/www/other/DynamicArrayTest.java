package www.other;

import org.ADT.DynamicArray;
import org.junit.Test;

/**
 * @author : chengdu
 * @date :  2024/3/26-03
 **/
public class DynamicArrayTest {

    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.add(0,1);
        for (int index = 0; index < dynamicArray.size(); index++) {
            System.out.println(dynamicArray.get(index));
        }
    }

}
