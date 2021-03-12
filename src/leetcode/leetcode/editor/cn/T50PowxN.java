//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 数学 二分查找 
// 👍 606 👎 0


package leetcode.leetcode.editor.cn;

public class T50PowxN {
    public static void main(String[] args) {
        Solution solution = new T50PowxN().new Solution();
        System.out.println(solution.myPow(2.00000, -2147483648));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            long N = n;
            return n >= 0 ? quikMi(x, N) : 1.0 / quikMi(x, -N);

        }

        /**
         * 快幂 二分 递归
         */
        private double quikMi(double x, long n) {
            if (n == 0) {
                return 1.0;
            }
            double y = quikMi(x, n / 2);
            return n % 2 == 0 ? y * y : y * y * x;
        }


        public double myPow2(double x, int n) {
            long N = n;
            return n >= 0 ? quikM2(x, N) : 1.0 / quikM2(x, -N);

        }


        /**
         * 快幂 迭代
         */
        private double quikM2(double x, long n) {
            double rst = 1.0;
            double x_contributr = x;
            while (n > 0) {
                if (n % 2 == 1) {
                    rst *= x_contributr;
                }
                x_contributr *= x_contributr;
                n = n / 2;
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}