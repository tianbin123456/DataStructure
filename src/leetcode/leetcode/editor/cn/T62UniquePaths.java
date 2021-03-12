//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 904 👎 0


/**
 * 1. 动态规划 f（m,n）=f(m-1,n)+f(m,n-1)
 * 2. 排列组合数学  如，m=3, n=2，我们只要向下 1 步，向右 2 步就一定能到达终点。从m+n-2中找出m-1/n-1次的组合排列数量
 * (m+n-2)!/((m-1）!(n-1)!)
 */
package leetcode.leetcode.editor.cn;

import java.util.Arrays;

public class T62UniquePaths {
    public static void main(String[] args) {
        Solution solution = new T62UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
//            return function1(m, n);
//            return function2(m, n);
            return function3(m, n);
        }

        private int function3(int m, int n) {
            long ans = 1;
            // (m+n-2)*(m+n-3)*....*n/1*2*3*....*(m-1)
            for (int x = n, y = 1; y < m; ++x, ++y) {
                ans = ans * x / y;
            }
            return (int) ans;
        }

        /**
         * 优化一维数组
         *
         * @param m
         * @param n
         * @return
         */
        private int function2(int m, int n) {
            //记录最后一行的数据，新增一行覆盖前一行
            int[] rst = new int[n];
            Arrays.fill(rst, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    rst[j] += rst[j - 1];
                }
            }
            return rst[n - 1];
        }


        private int function1(int m, int n) {
            int[][] rst = new int[m][n];
            //初始化边界值 第一行 第一列为1
            for (int i = 0; i < rst.length; i++) {
                rst[i][0] = 1;
            }
            Arrays.fill(rst[0], 1);
            for (int i = 1; i < rst.length; i++) {
                for (int j = 1; j < rst[0].length; j++) {
                    rst[i][j] = rst[i - 1][j] + rst[i][j - 1];
                }
            }
            return rst[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}