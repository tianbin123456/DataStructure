//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//
// 
//
// 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 300 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 1003 👎 0


package leetcode.leetcode.editor.cn;

public class T41FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new T41FirstMissingPositive().new Solution();
        int[] nums = {1};
        solution.firstMissingPositive(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1.将负数变为 length+1 最大值为length+1
         * 2.将每个数-1的位置置为负数（位置最大为length-1）
         * 3.从第一个位置开始 如果全为负数 则最大为length+1  否则为第一个正数位置+1（因为当前位置无数字对应所有没变成负数）
         */
        public int firstMissingPositive(int[] nums) {
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                if (nums[i] < 1) {
                    nums[i] = length + 1;
                }
            }

            for (int i = 0; i < length; i++) {
                int num = Math.abs(nums[i]);
                if (num <= length) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }

            for (int i = 0; i < length; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return length + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}