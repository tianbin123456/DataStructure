//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1024 👎 0


package leetcode.leetcode.editor.cn;

import java.util.HashMap;

public class T76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new T76MinimumWindowSubstring().new Solution();
        String s = "a";
        String t = "b";
        System.out.println(solution.minWindow(s, t));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            //总字符串
            int total = t.length();
            //字符map
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            //前指针
            int front = 0;
            //后指针
            int after = 0;
            //最短字串长度
            int min = Integer.MAX_VALUE;
            //最短字串起
            int start = -1;
            //最短字串终
            int end = -1;
            while (after < s.length()) {
                char c = s.charAt(after);
                if (map.containsKey(c)) {
                    Integer integer = map.get(c);
                    if (integer > 0) {
                        total--;
                    }
                    map.put(c, integer - 1);
                }
                if (total == 0) {
                    while (true) {
                        char c1 = s.charAt(front);
                        if (map.containsKey(c1)) {
                            if (map.get(c1) == 0) {
                                //字串长度
                                int sum = after - front + 1;
                                if (min > sum) {
                                    min = sum;
                                    start = front;
                                    end = after;
                                }
                                break;
                            } else {
                                map.put(c1, map.get(c1) + 1);
                            }
                        }
                        front++;
                    }
                }
                after++;
            }

            if (min == Integer.MAX_VALUE) {
                return "";
            } else {
                return s.substring(start, end + 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}