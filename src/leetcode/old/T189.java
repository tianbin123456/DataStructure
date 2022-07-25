package leetcode.old;


/**
 * @Author: T
 * @Date: 2020/9/1 14:08
 * @Description: leetcode 189 	旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class T189 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        rotate2(a, 4);
        for (int i : a) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    /**
     * 环形移动
     * 直接移动到最终位置，将被占位置的值存入临时变量，然后找到下一个位置放入，最后将最后一个值放入起使位置，总共需要移动数组长度n次。
     * 存在一次移动全部完成的情况和需要多次移动的情况
     * 当 数组长度n 和 k 的最大公约数 等于 1 的时候：1 次遍历就可以完成交换；比如 n = 5, k = 3 m=1
     * 当 数组长度n 和 k 的最大公约数 不等于 1 的时候：1 次遍历是无法完成的所有元素归位，需要 m (最大公约数) 次 比如 n = 6, k = 4 m=2
     * 当 k > n时 实际移动位置 k = k % n
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int count = 0;
        for (int i = 0; i < k; i++) {
            int start = i;
            int temp = nums[start];
            i = i + k < len ? i + k : i + k - len;
            while (i != start) {
                int temp2 = nums[i];
                nums[i] = temp;
                temp = temp2;
                i = i + k < len ? i + k : i + k - len;
                count++;
            }
            nums[i] = temp;
            count++;
            if (count == len) {
                break;
            }
        }
    }

    /**
     * 数组反转
     * 1.{1，2，3，4，5，6} ->{6，5，4，3，2，1}
     * 2.反转0-（k-1）的值->{3，4，5，6，2，1}
     * 3.反转k-(n-1)的值->{3,4,5,6,1,2}
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
