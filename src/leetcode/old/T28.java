package leetcode.old;

/**
 * @Author: T
 * @Date: 2020/9/9 14:38
 * @Description: 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T28 {
    public static void main(String[] args) {
        String haystack = "ababadcabababca";
        String needle = "abababca";
        System.out.print(strStr(haystack, needle));

    }


    /**
     * 1.for循环 暴力破解
     * 2.暴力破解优化  判断当前字符是否在需要查找的串中 ，不在，直接跳到下一位进行比较
     * 3.KMP算法  前缀回溯，判断下一次比较位置。 核心 getNext数组
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(needle, next);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j >= needle.length()) {
            return (i - needle.length());
        } else {
            return -1;
        }
    }

    public static void getNext(String needle, int[] next) {
        int i = 0, j = -1;
        next[0] = -1;
        while (i < needle.length() - 1) {
            if (j == -1 || needle.charAt(j) == needle.charAt(i)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    /**
     * 4.BM算法  字串从后往前比较，好后缀和前缀比较，判断下一次比较位置。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {

        return -1;
    }
}
