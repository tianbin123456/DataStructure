/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：num = 16
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：num = 14
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num <= 2^31 - 1
 * <p>
 * <p>
 * Related Topics 数学 二分查找 👍 420 👎 0
 */

package leetcode.leetcode.editor.cn;

public class T367ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new T367ValidPerfectSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分查找
        public boolean isPerfectSquare(int num) {
            int left = 0;
            int right = num;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                long x = (long) mid * mid;
                if (x == num) {
                    return true;
                } else if (x > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;

        }
//使用内置函数
//        public boolean isPerfectSquare(int num) {
//            int sqrt = (int) Math.sqrt(num);
//            return sqrt * sqrt == num;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}