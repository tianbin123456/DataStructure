/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * 提示：
 * <p>
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是
 * 无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 11111111111111111111111111111101
 * 输出：3221225471 (10111111111111111111111111111111)
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *   因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 输入是一个长度为 32 的二进制字符串
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶: 如果多次调用这个函数，你将如何优化你的算法？
 * <p>
 * Related Topics 位运算 分治 👍 562 👎 0
 */

package leetcode.leetcode.editor.cn;

public class T190ReverseBits {
    public static void main(String[] args) {
        Solution solution = new T190ReverseBits().new Solution();
        int i = solution.reverseBits(-3);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res <<= 1;
                res += n & 1;
                n >>= 1;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}