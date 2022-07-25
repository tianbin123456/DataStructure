package leetcode.old;

/**
 * @Author: tianbin9611
 * @Date: 2020/9/18 13:49
 * @Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T70 {

    public static void main(String[] args) {

        System.out.println(climbStairs2(5));


    }

    /**
     * 递归， 到达楼顶的最后一步有两种走法，
     * f（n）=f(n-1)+f(n-2)
     * 会出现重复计算的情况
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 正向递推
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 1;
        int x = 0;
        int y = 0;
        while (n >= 1) {
            n--;
            x = y;
            y = sum;
            sum = x + y;
        }
        return sum;
    }
}
