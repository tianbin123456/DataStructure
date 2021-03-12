//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1091 👎 0


/**
 * 动态规划 fn = min(f(n-x1),f(n-x2),f(n-x3)...)+1
 */
package leetcode.leetcode.editor.cn;

import java.util.Arrays;

public class T322CoinChange {
    public static void main(String[] args) {
        Solution solution = new T322CoinChange().new Solution();
        int[] coins = {186, 419, 83, 408};
        System.out.println(solution.coinChange(coins, 6249));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int dp[] = new int[amount + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (coin <= i) {
                        //计算的值与原值比大小，原值为-1则直接覆盖取新值
                        int temp = dp[i - coin] == -1 ? -1 : dp[i - coin] + 1;
                        if (temp > -1) {
                            if (dp[i] == -1) {
                                dp[i] = temp;
                            } else {
                                dp[i] = Math.min(dp[i], temp);
                            }
                        }
                    }
                }
            }
            return dp[amount];
        }

        public int f1(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (coin <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}