//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找 
// 👍 520 👎 0


package leetcode.leetcode.editor.cn;

public class T29DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new T29DivideTwoIntegers().new Solution();
        System.out.println(solution.divide(-1010369383, -2147483648));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1. 通过除数不断相加，计算出大致的范围。
         * 2.在范围内通过二分法，计算出准确的数。
         */
        public int divide(int dividend, int divisor) {
            long dividend2 = dividend;
            long divisor2 = divisor;
            if (dividend == 0) {
                return 0;
            }
            if (dividend == divisor) {
                return 1;
            }
            if (divisor == 1) {
                return dividend;
            }
            if (divisor == -1) {
                long dividend1 = dividend;
                if (-dividend1 > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                return (int) -dividend1;
            }
            //符号相同
            if ((dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0)) {
                return (int) myDivide(Math.abs(dividend2), Math.abs(divisor2));
            } else {
                return (int) -myDivide(Math.abs(dividend2), Math.abs(divisor2));
            }
        }

        private long myDivide(long dividend, long divisor) {
            long min = 0;
            long max;
            long sum;
            if (dividend == divisor) {
                return 1;
            }
            if (dividend > divisor) {
                max = 1;
                sum = divisor;
                while (dividend > sum) {
                    sum += sum;
                    min = max;
                    max += max;
                    if (dividend == sum) {
                        return max;
                    }
                }
            } else {
                return 0;
            }

            return erfen(min, max, dividend, divisor, sum >> 1, sum);
        }

        private long erfen(long min, long max, long dividend, long divisor, long minSum, long maxSum) {
            while (min < max) {
                //获取中间值
                long mid = minSum + ((maxSum - minSum) >> 1);
                if (mid == dividend) {
                    return min + ((max - min) >> 1);
                }
                if (mid < dividend) {
                    min = min + ((max - min) >> 1);
                    minSum = mid;
                } else {
                    max = min + ((max - min) >> 1);
                    maxSum = mid;
                }
            }
            return min;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}