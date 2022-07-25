package leetcode.old;

/**
 * @Author: T
 * @Date: 2020/9/3 16:13
 * @Description: T283
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 输入: [0,0,3,0,12]
 * 输出: [3,12,0,0,0]
 * [4,2,4,0,0,3,0,5,1,0]
 * [4,2,4,3,5,1,0,0,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T283 {
    public static void main(String[] args) {

        int[] a = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes2(a);
        for (int x : a) {
            System.out.print(x + ",");
        }
    }


    /**
     * 双指针交换  后值前移  指针到数组尾部，最后全为0
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (; i < nums.length; ) {
            if (nums[i] == 0) {
                i++;
            } else {
                nums[j] = nums[i];
                i++;
                j++;
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }

    }

    /**
     * 双指针交换 值交换
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int i = 0, j = 0;
        for (; i < nums.length; ) {
            if (nums[i] == 0) {
                i++;
            } else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
        }
    }

}
