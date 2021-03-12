//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1429 👎 0


package leetcode.leetcode.editor.cn;

public class T300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new T300LongestIncreasingSubsequence().new Solution();
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            return solution1(nums);
//            return solution2(nums);
        }

        /**
         * 依次计算，已当前值为最长子序列结尾的长度。
         * 最长长度dp[i]=dp[j]+1;
         *
         * @param nums
         * @return
         */
        private int solution1(int[] nums) {
            int length = 1;
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                length = Math.max(length, dp[i]);
            }
            return length;
        }

        /**
         * 贪心 加 二分查找最近值
         * 无序子列不需要关心子序列的具体数据，前面子序列数据越小，则越往后越容易组成长的子序列。
         * 维护一个满足条件的子序列。
         * 符合大于最结尾数据的追加，小于结尾数据的，找到子序列中的第一个小于当前数 d[k]，更新k+1位置的数据。
         *
         * @param nums
         * @return
         */
        private int solution2(int[] nums) {
            int length = 1;
            int[] rst = new int[nums.length + 1];
            //length为子序列已存值位置 即子序列长度
            rst[length] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > rst[length]) {
                    rst[++length] = nums[i];
                } else {
                    int l = 1;
                    int r = length;
                    //如果所有的数据比当前值答，则更新rst[1];
                    int pos = 0;
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (rst[mid] < nums[i]) {
                            pos = mid;
                            l = ++mid;
                        } else {
                            r = --mid;
                        }
                    }
                    rst[pos + 1] = nums[i];
                }
            }
            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}