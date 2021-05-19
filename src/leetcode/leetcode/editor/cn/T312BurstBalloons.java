//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics 分治算法 动态规划 
// 👍 722 👎 0


package leetcode.leetcode.editor.cn;

public class T312BurstBalloons {
    public static void main(String[] args) {
        Solution solution = new T312BurstBalloons().new Solution();
        int[] num={3,1,5,8};
        System.out.println(solution.maxCoins(num));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] nums) {
            /**
             * 1.计算最大硬币数需要穷举所以可能
             * 2.使用动态规划计算 计算dp[i][j] 代表i至j之间的最大数
             * 3.扩展数组num[0]=n[n+1]=1;计算1到n之间的最大数。其中0，n+1,不可破
             * 4.二分，计算i到j的最大值，假设最后戳破k，则dp[i][j]=dp[i][k]+dp[k][j]+num[i]*num[k]*num[j]
             * 4.限定条件，1<=i,j<=n,当i>=j-1时，中间没有数据dp[i][j]=0;
             * 5.循环穷举i，j
             */
            int n = nums.length;
            int[] nums2 = new int[n + 2];
            nums2[0] = nums2[n + 1] = 1;
            for (int i = 1; i <= n; i++) {
                nums2[i] = nums[i - 1];
            }
            int[][] dp = new int[n + 2][n + 2];
            /**
             * 从后往前，从少往多，遍历。
             */
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 2; j < n + 2; j++) {
                    for (int k = i + 1; k < j; k++) {
                        int temp = dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j];
                        dp[i][j]=Math.max(dp[i][j],temp);
                    }
                }
            }
            return dp[0][n+1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}