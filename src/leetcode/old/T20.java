package leetcode.old;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: tianbin9611
 * @Date: 2020/9/27 09:59
 * @Description: 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class T20 {

    public static void main(String[] args) {

        String s = "";
        System.out.println(isValid2(s));

    }

    /**
     * 利用栈的特点
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        String[] split = s.split("");
        if (split.length % 2 != 0) {
            return false;
        }
        Deque<String> stack = new LinkedList<>();
        for (String symbol : split) {
            if ("(".equals(symbol) || "{".equals(symbol) || "[".equals(symbol)) {
                stack.push(symbol);
            }
            if (")".equals(symbol) || "}".equals(symbol) || "]".equals(symbol)) {
                if (stack.size() == 0) {
                    return false;
                }
            }
            if (")".equals(symbol)) {
                String pop = stack.pop();
                if (!"(".equals(pop)) {
                    return false;
                }
            }
            if ("}".equals(symbol)) {
                String pop = stack.pop();
                if (!"{".equals(pop)) {
                    return false;
                }
            }
            if ("]".equals(symbol)) {
                String pop = stack.pop();
                if (!"[".equals(pop)) {
                    return false;
                }
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }

    /**
     * 利用栈的特点  优化
     *
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(pairs.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
