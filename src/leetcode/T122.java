package leetcode;

/**
 * @Author: T
 * @Date: 2020/8/31 14:52
 * @Description:
 */
public class T122 {


    public static void main(String[] args) {
        int[] a = {7, 1, 2, 3, 4, 5};
        System.out.println(maxProfit4(a));
    }

    /**
     * 找出所有上升的交易计算
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int a;
        int b;
        int in = -1;
        int out = -1;
        int get = 0;
        for (int i = 1; i < prices.length; i++) {
            a = prices[i - 1];
            b = prices[i];
            if (a < b && in < 0) {
                in = a;
                out = b;
            }
            if (a < b && in >= 0) {
                out = b;
            }
            if (a > b && in >= 0) {
                get += out - in;
                out = -1;
                in = -1;
            }
            if (i == prices.length - 1 && in >= 0) {
                get += prices[i] - in;
            }
        }
        return get;
    }

    /**
     * 找出所有上升的交易计算
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int a;
        int b;
        int in = -1;
        int get = 0;
        for (int i = 1; i < prices.length; i++) {
            a = prices[i - 1];
            b = prices[i];
            if (a < b && in < 0) {
                in = a;
            }
            if (a > b && in >= 0) {
                get += a - in;
                in = -1;
            }
            if (i == prices.length - 1 && in >= 0) {
                get += prices[i] - in;
            }
        }
        return get;
    }

    /**
     * 找出所有上升的交易计算
     *
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        int in = -1;
        int get = 0;
        for (int i = 1; i < prices.length; i++) {
            //获取买入点
            if (prices[i - 1] < prices[i] && in < 0) {
                in = prices[i - 1];
            }
            //获取卖出点
            if (prices[i - 1] > prices[i] && in >= 0) {
                get += prices[i - 1] - in;
                in = -1;
            }
            //处理连续上升边界值
            if (i == prices.length - 1 && in >= 0) {
                get += prices[i] - in;
            }
        }
        return get;
    }

    /**
     * 简单的将上升的数据算入利润
     *
     * @param prices
     * @return
     */
    public static int maxProfit4(int[] prices) {
        int get = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                get += prices[i] - prices[i - 1];
            }
        }
        return get;
    }

}
