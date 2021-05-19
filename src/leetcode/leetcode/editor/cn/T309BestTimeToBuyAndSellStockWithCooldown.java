  //给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 769 👎 0

  
  package leetcode.leetcode.editor.cn;
  public class T309BestTimeToBuyAndSellStockWithCooldown{
      public static void main(String[] args) {
           Solution solution = new T309BestTimeToBuyAndSellStockWithCooldown().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        //买入 金额减当前买入价  卖出加上当前价
        //具有3种状态 每种状态计算金额
        //买入持有
        int f0=-prices[0];
        //冷冻期
        int f1=0;
        //非冷冻期
        int f2=0;
        for (int i = 1; i < prices.length; i++) {
            //当天处于买入持有期的  只可能是前一天持有 和当天买入
            int temp0=Math.max(f0,f2-prices[i]);
            //当天处于冷冻期的只有可能是当天卖出
            int temp1=f0+prices[i];
            //当天处于非冷冻期的 只有可能是前一天是冷冻期或 前一天就是非冷冻期
            int temp2=Math.max(f1,f2);
            f0=temp0;
            f1=temp1;
            f2=temp2;
        }
        return Math.max(f1,f2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }