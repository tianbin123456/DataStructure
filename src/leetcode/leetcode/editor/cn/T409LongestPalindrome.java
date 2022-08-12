/**
 * 给定一个包含大写字母和小写字母的字符串
 * s ，返回 通过这些字母构造成的 最长的回文串 。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入:s = "a"
 * 输入:1
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入:s = "bb"
 * 输入: 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= s.length <= 2000
 * s 只能由小写和/或大写英文字母组成
 * <p>
 * <p>
 * Related Topics 贪心 哈希表 字符串 👍 442 👎 0
 */

package leetcode.leetcode.editor.cn;

public class T409LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new T409LongestPalindrome().new Solution();
        solution.longestPalindrome("abccccdd");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            int length = s.length();
            int[] ints = new int[128];
            for (int i = 0; i < length ; i++) {
                char c = s.charAt(i);
                ints[c]++;
            }
            int rst = 0;
            for (int anInt : ints) {
                rst += anInt / 2 * 2;
                if (anInt % 2 == 1 && rst % 2 == 0) {
                    rst++;
                }
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}