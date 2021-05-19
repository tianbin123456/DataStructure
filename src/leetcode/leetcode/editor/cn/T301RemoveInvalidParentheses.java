//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: "()())()"
//输出: ["()()()", "(())()"]
// 
//
// 示例 2: 
//
// 
//输入: "(a)())()"
//输出: ["(a)()()", "(a())()"]
// 
//
// 示例 3: 
//
// 
//输入: ")("
//输出: [""] 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 410 👎 0


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class T301RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new T301RemoveInvalidParentheses().new Solution();
        List<String> strings = solution.removeInvalidParentheses("()())()");
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashSet<String> set = new HashSet<>();
        int length;
        char[] chars;

        public List<String> removeInvalidParentheses(String s) {
            int leftRemove = 0;
            int rightRemove = 0;
            chars = s.toCharArray();
            length = s.length();
            for (int i = 0; i < length; i++) {
                if ('(' == (chars[i])) {
                    leftRemove++;
                } else if (')' == (chars[i])) {
                    if (leftRemove == 0) {
                        rightRemove++;
                    } else {
                        leftRemove--;
                    }
                }
            }
            StringBuffer sb = new StringBuffer();
            dfs(0, 0, 0, leftRemove, rightRemove, sb);
            return new ArrayList<>(set);

        }

        private void dfs(int index, int leftCount, int rightCount, int leftRemove, int rightRemove, StringBuffer sb) {

            if (index == length) {
                if (leftRemove == 0 && rightRemove == 0) {
                    set.add(sb.toString());
                }
                return;
            }
            if ('(' == chars[index] && leftRemove > 0) {
                dfs(index+1, leftCount, rightCount, leftRemove-1, rightRemove, sb);
            }
            if (')' == chars[index] && rightRemove > 0) {
                dfs(index+1, leftCount, rightCount, leftRemove, rightRemove-1, sb);
            }
            sb.append(chars[index]);

            if ('(' != chars[index] && ')' != chars[index]) {
                dfs(index+1, leftCount, rightCount, leftRemove, rightRemove, sb);
            } else if ('(' == chars[index]) {
                dfs(index+1, leftCount+1, rightCount, leftRemove, rightRemove, sb);
            } else if (')' == chars[index] && rightCount < leftCount) {
                //为右括号 且 左括号数大于右括号数 则 右括号加一
                dfs(index+1, leftCount, rightCount+1, leftRemove, rightRemove, sb);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}