/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入:a = "11", b = "1"
 * 输出："100"
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= a.length, b.length <= 10⁴
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 * <p>
 * <p>
 * Related Topics 位运算 数学 字符串 模拟 👍 890 👎 0
 */

package leetcode.leetcode.editor.cn;

public class T67AddBinary {
    public static void main(String[] args) {
        Solution solution = new T67AddBinary().new Solution();
        System.out.println(solution.addBinary("1010", "1011"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if (a.equals("0")) {
                return b;
            }
            if (b.equals("0")) {
                return a;
            }
            int alength = a.length();
            int blength = b.length();
            StringBuilder longS;
            StringBuilder shortS;
            StringBuilder aR = new StringBuilder(a).reverse();
            StringBuilder bR = new StringBuilder(b).reverse();
            if (alength > blength) {
                longS = aR;
                shortS = bR;
            } else {
                longS = bR;
                shortS = aR;
            }
            for (int i = 0; i < shortS.length(); i++) {
                char c = shortS.charAt(i);
                if (c == '1') {
                    char carry = '1';
                    int j = i;
                    while (carry == '1') {
                        if (j == longS.length()) {
                            longS.append("1");
                            carry = '0';
                        } else {
                            char c1 = longS.charAt(j);
                            if (c1 == '0') {
                                longS.replace(j, j + 1, "1");
                                carry = '0';
                            } else {
                                longS.replace(j, j + 1, "0");
                                j++;
                            }
                        }
                    }

                }
            }

            return longS.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}