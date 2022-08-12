/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s 由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 贪心 双指针 字符串 👍 521 👎 0
 */

package leetcode.leetcode.editor.cn;

public class T680ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new T680ValidPalindromeIi().new Solution();
        solution.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int low = 0, high = s.length() - 1;
            while (low < high) {
                char c1 = s.charAt(low), c2 = s.charAt(high);
                if (c1 == c2) {
                    ++low;
                    --high;
                } else {
                    return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
                }
            }
            return true;
        }

        public boolean validPalindrome(String s, int low, int high) {
            for (int i = low, j = high; i < j; ++i, --j) {
                char c1 = s.charAt(i), c2 = s.charAt(j);
                if (c1 != c2) {
                    return false;
                }
            }
            return true;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}