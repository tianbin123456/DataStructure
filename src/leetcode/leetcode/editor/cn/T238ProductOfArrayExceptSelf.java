//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 
// 👍 753 👎 0


package leetcode.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class T238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new T238ProductOfArrayExceptSelf().new Solution();
        int[] nums = {1, 2, 3, 4};
        solution.productExceptSelf(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 左右乘积法 先正向算出左侧的积 再逆向算右侧的积
         *
         * @param nums
         * @return
         */
        public int[] productExceptSelf(int[] nums) {
            int[] rst = new int[nums.length];
            Arrays.fill(rst, 1);
            for (int i = 1; i < nums.length; i++) {
                rst[i] = rst[i - 1] * nums[i - 1];
            }
            int r = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                rst[i] = rst[i] * r;
                r = r * nums[i];
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}