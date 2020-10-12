package leetcode;

/**
 * @Author: tianbin9611
 * @Date: 2020/10/12 16:28
 * @Description: 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class T3 {

    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 遍历 滑动窗口
     * 直接进到上个相等字符后，进行下一次遍历递进
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        //记录最大长度
        int max = 0;
        //记录当前字符串开始位置
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String s1 = s.substring(index, i);
            if (s1.contains(String.valueOf(c))) {
                int i1 = s.indexOf(c, index);
                index = i1 + 1;
                max = Math.max(max, s1.length());
            } else {
                max = Math.max(max, s1.length() + 1);
            }
        }
        return max;
    }
}
