package leetcode.array_and_string;

public class Solution1991 {

    /**
     给你一个整数数组 nums ，请计算数组的 中心下标 。

     数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。

     如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。

     如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。

     输入：nums = [1, 7, 3, 6, 5, 6]
     输出：3
     解释：
     中心下标是 3 。
     左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
     右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。

     输入：nums = [1, 2, 3]
     输出：-1
     解释：
     数组中不存在满足此条件的中心下标。


     输入：nums = [2, 1, -1]
     输出：0
     解释：
     中心下标是 0 。
     左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
     右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
     */

    /**
     * 寻找数组的中心索引
     *
     * @param arr
     * @return
     */
    @Deprecated
    public static int pivotIndex2(int[] arr) {
        int centerLen = -1;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < arr.length; i++) {
            //初始化
            leftSum = 0;
            rightSum = 0;
            //计算左边
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            //计算右边
            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) {
                centerLen = i;
                break;
            }
        }
        return centerLen;
    }

    /**
     * 寻找数组的中心索引
     *
     * @param arr
     * @return
     */
    public static int pivotIndex(int[] arr) {
        int centerLen = -1;
        int allSum = 0;
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            allSum += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            //初始化
            leftSum = 0;
            //计算左边
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            leftSum = leftSum * 2 + arr[i];
            if (leftSum == allSum) {
                centerLen = i;
                break;
            }
        }
        return centerLen;
    }

    /**
     * 合并区间
     *
     * @param intervals
     * @return
     */
    public static int[][] mergeArray(int[][] intervals) {
        final int length = intervals.length;
        int removeIndex = 0;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (intervals[j].length == 0 || intervals[j + 1].length == 0) {
                    continue;
                }
                if (intervals[j][1] >= intervals[j + 1][0] && intervals[j][0] < intervals[j + 1][0]) {
                    intervals[j] = new int[]{intervals[j][0], intervals[j + 1][1]};
                    intervals[j + 1] = new int[0];
                    removeIndex++;
                } else if (intervals[j][1] == intervals[j + 1][1] && intervals[j][0] == intervals[j + 1][0]) {
                    intervals[j] = new int[]{intervals[j][0], intervals[j + 1][1]};
                    intervals[j + 1] = new int[0];
                    removeIndex++;
                }else if (intervals[j][1] <= intervals[j + 1][1] && intervals[j][0] >= intervals[j + 1][0]){
                    intervals[j] = intervals[j+1];
                    intervals[j + 1] = new int[0];
                    removeIndex++;
                }
            }
        }
        //处理冗余数据
        int[][] arr = new int[length - removeIndex][2];
        int i = 0;
        for (int j = 0; j < intervals.length; j++) {
            if (intervals[j].length == 0) {
                continue;
            }
            arr[i++] = intervals[j];
        }
        return arr;
    }


    /**
     * 搜索插入位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;
        for (; left <= right; ) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                //向左边查找
                left = mid + 1;
            } else {
                //向右查找
                right = mid - 1;
            }
        }
        return left;
    }

    public static int getIndex(int[] arr, int target) {
        int index = -1;
        int right = arr.length - 1;
        int left = 0;
        int mid = 0;
        for (; left <= right; ) {
            mid = (right + left) / 2;
            if (target == arr[mid]) {
                index = mid;
                break;
            } else if (target > arr[mid]) {
                //向左边查找
                left = mid + 1;
            } else {
                //向右查找
                right = mid - 1;
            }
        }
        return index;
    }


}
