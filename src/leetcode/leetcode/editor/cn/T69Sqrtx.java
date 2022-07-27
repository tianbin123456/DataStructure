/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：x = 4
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= x <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 数学 二分查找 👍 1090 👎 0
 */

package leetcode.leetcode.editor.cn;

public class T69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new T69Sqrtx().new Solution();
        System.out.println(solution.mySqrt(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {

            int left = 0;
            int right = (int) Math.sqrt(Integer.MAX_VALUE);
            if (right > x) {
                right = x;
            }
            int ans = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid * mid <= x) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
//        public int mySqrt(int x) {
//
//            int left = 0;
//            int right = (int) Math.sqrt(Integer.MAX_VALUE);
//            if (right > x) {
//                right = x;
//            }
//            while (left < right) {
//                int mid = left + (right - left) / 2;
//                if (mid * mid < x) {
//                    if ((mid + 1) * (mid + 1) > x) {
//                        return mid;
//                    }
//                    left = mid + 1;
//                } else if (mid * mid == x) {
//                    return mid;
//                } else if (mid * mid > x) {
//                    right = mid - 1;
//                }
//            }
//            return left;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}