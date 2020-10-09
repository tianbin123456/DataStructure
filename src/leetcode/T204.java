package leetcode;

import java.util.Arrays;

/**
 * @Author: tianbin9611
 * @Date: 2020/9/24 16:49
 * @Description: 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class T204 {


    public static void main(String[] args) {
        System.out.println(countPrimes2(10));
    }


    /**
     * 题解 质数的计算至需要计算到 sqrt（n）就行。
     * 1.暴力 for循环，从 2开始循环 计算每一个值是否是质数，直到 sqrt（n）为止。
     * <p>
     * 2.厄拉多塞筛法
     * 要得到自然数n以内的全部素数，必须把不大于根号n的所有素数的倍数剔除，剩下的就是素数。
     * 同时考虑到大于2的偶数都不是素数，所以可以进一步优化成：
     * 3.要得到自然数n以内的全部素数，必须把不大于根号n的所有素数的奇数倍剔除，剩下的奇数就是素数
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {

        //为false的是质数
        boolean[] booleans = new boolean[n];
        //从2开始计算
        for (int i = 2; i < n; i++) {
            if (!booleans[i]) {
                //优化 j 可以走i*i 开始计算，因为小于i的已经计算过了。
                for (int j = i * i; j < n; j += i) {
                    //不是质数的转为true
                    booleans[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!booleans[i]) {
                count++;
            }
        }
        return count;
    }

    public static int countPrimes2(int n) {

        int result = 0, sqrt_n = (int) Math.sqrt(n);
        // 初始化默认值都为 false，为质数标记
        boolean[] b = new boolean[n];
        // 如果大于 2 则一定拥有 2 这个质数
        if (2 < n) {
            result++;
        }
        // 从 3 开始遍历，且只遍历奇数
        for (int i = 3; i < n; i += 2) {
            //当前数是质数则改变他的倍数为 非质数
            if (!b[i]) {
                //不大于根号n
                if (i <= sqrt_n) {
                    for (int j = i; i * j < n; j += 2) {
                        // 将当前质数的奇数倍都设置成非质数标记 true
                        b[i * j] = true;
                    }
                }
                result++;   // 质数个数 +1
            }
        }
        return result;
    }
}
