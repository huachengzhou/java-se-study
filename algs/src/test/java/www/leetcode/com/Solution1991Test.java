package www.leetcode.com;

import leetcode.array_and_string.Solution1991;
import org.junit.Test;

public class Solution1991Test {


    @Test
    public void test1() {
        int[] arr = new int[]{};

//        arr = new int[]{1, 7, 3, 6, 5, 6} ;
//        arr = new int[]{4, 2, 3, 4, 5, 4} ;
        arr = new int[]{1, 2, 3};
        arr = new int[]{2, 1, -1};

        int index = Solution1991.pivotIndex(arr);
        System.out.println("index:" + index);
        System.out.println(Solution1991.searchInsert(new int[]{1, 2, 3, 5, 98}, 7));
        System.out.println(Solution1991.getIndex(new int[]{1, 2, 3, 5, 98}, 5));
    }


}
