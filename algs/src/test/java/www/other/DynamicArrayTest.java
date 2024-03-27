package www.other;

import org.ADT.DynamicArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : chengdu
 * @date :  2024/3/26-03
 **/
public class DynamicArrayTest {

    @Test
    public void test_add() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(0, 1);
        for (int index = 0; index < dynamicArray.size(); index++) {
            System.out.println(dynamicArray.get(index));
        }
    }


    @Test
    public void test_foreach() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(0, 1);

//        dynamicArray.foreach(ele -> System.out.println(ele));

//        for (Integer ele : dynamicArray) {
//            System.out.println(ele);
//        }

        dynamicArray.stream().forEach(ele -> System.out.println(ele));

//        for (int index = 0; index < dynamicArray.size(); index++) {
//            System.out.println(dynamicArray.get(index));
//        }
    }

    @Test
    public void test_removed() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        Assert.assertTrue("不相等", dynamicArray.remove(0) == 2);
        dynamicArray.stream().forEach(ele -> System.out.println(ele));
    }

    /**
     * 测试扩容
     */
    @Test
    public void test_extend(){
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 100 ; i++) {
            dynamicArray.addLast(i);
        }
        dynamicArray.forEach(integer -> System.out.println(integer));
    }


}
