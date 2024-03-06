package www.other;

import org.find.DemoBinarySearch;
import org.junit.Assert;
import org.junit.Test;


/**
 * 二分查找demo
 */
public class DemoBinarySearchTest {

    @Test
    public void test5() {
        int[] intArray = new int[]{6, 13, 16, 22, 24, 32, 40, 53, 61, 74, 94, 95, 97, 97, 99};
        int target = 6;
        int index = DemoBinarySearch.rightMostBinarySearch(intArray, target);
        String str = index >= 0 ? String.valueOf(intArray[index]) : "";
        System.out.println(index + " " + str);
        Assert.assertEquals("不相等", str, String.valueOf(target));
    }

    @Test
    public void test4() {
        int[] intArray = new int[]{6, 13, 16, 22, 24, 32, 40, 53, 61, 74, 94, 95, 97, 97, 99};
        int target = 75;
        int index = DemoBinarySearch.leftMostBinarySearch(intArray, target);
        String str = index >= 0 ? String.valueOf(intArray[index]) : "";
        System.out.println(index + " " + str);
        Assert.assertEquals("不相等", str, String.valueOf(target));
    }

    @Test
    public void test3() {
        int[] intArray = new int[]{6, 13, 16, 22, 24, 32, 40, 53, 61, 74, 94, 95, 97, 97, 99};
        int target = 41;
        int index = DemoBinarySearch.rightMostBinarySearch1(intArray, target);
        String str = index >= 0 ? String.valueOf(intArray[index]) : "";
        System.out.println(index + " " + str);
        Assert.assertEquals("不相等", str, String.valueOf(target));
    }

    @Test
    public void test2() {
        int[] intArray = new int[]{6, 13, 16, 22, 24, 32, 40, 53, 61, 74, 94, 95, 97, 97, 99};
        int target = 100;
        int index = DemoBinarySearch.leftMostBinarySearch1(intArray, target);
        String str = index >= 0 ? String.valueOf(intArray[index]) : "";
        System.out.println(index + " " + str);
        Assert.assertEquals("不相等", str, String.valueOf(target));
    }

    @Test
    public void test1() {
        int[] intArray = new int[]{6, 13, 16, 22, 24, 32, 40, 53, 61, 74, 94, 95, 97, 97, 99};
        int target = 100;
        int index = DemoBinarySearch.binarySearch1(intArray, target);
        String str = index >= 0 ? String.valueOf(intArray[index]) : "";
        System.out.println(index + " " + str);
        Assert.assertEquals("不相等", str, String.valueOf(target));
    }

    @Test
    public void test0() {
        int[] intArray = new int[]{6, 13, 16, 22, 24, 32, 40, 53, 61, 74, 94, 95, 97, 97, 99};
        int target = 16;
        int index = DemoBinarySearch.binarySearch(intArray, target);
        String str = index >= 0 ? String.valueOf(intArray[index]) : "";
        System.out.println(index + " " + str);
        Assert.assertEquals("不相等", str, String.valueOf(target));
    }

}
