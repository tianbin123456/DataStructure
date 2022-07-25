package leetcode.old;

import java.util.Arrays;

/**
 * @Author: T
 * @Date: 2020/9/2 14:55
 * @Description: T 136 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T136 {
    public static void main(String[] args) {

        int[] a = {1, 3, 1, -1, 3};
        System.out.println(singleNumber3(a));
    }

    /**
     * 二分查找 先排序
     * 中值两边有单数个值时，查找值和比较值不同侧
     * 例 1，1，2  中值为nums[1]=1  左右各一个数，比较值 nums[0]=1 在中值左侧 查找值为2 在中值右边
     * 中值两边有单数个值时，查找值在比较值的同一边数组
     * 例 1，2，2，3，3  中值为nums[2]=2  左右各两个数，比较值 nums[1]=2 在中值左侧 查找值为1 在中值左侧
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        return find(nums, 0, nums.length - 1);
    }

    public static int find(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        //中值位置
        int i = (start + end) / 2;
        //数组中值两边数据的单双数
        int j = (start + end) / 2 % 2;
        if (nums[i] == nums[i + 1]) {
            if (j > 0) {
                //单数 不同侧
                return find(nums, start, i - 1);
            } else {
                //双数 同侧
                return find(nums, i + 2, end);
            }

        }
        if (nums[i] == nums[i - 1]) {
            if (j > 0) {
                //单数 不同侧
                return find(nums, i + 1, end);
            } else {
                //双数 同侧
                return find(nums, start, i - 2);
            }
        }
        return nums[i];
    }

    /**
     * 先排序 后循环比较前后值 每次跳过两个位置
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * 位运算 异或
     * a^a =0
     * a^b^a=b
     *
     * @param nums
     * @return
     */
    public static int singleNumber3(int[] nums) {
        int rst = 0;
        for (int num : nums) {
            rst ^= num;
        }
        return rst;
    }
}
