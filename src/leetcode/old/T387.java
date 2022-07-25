package leetcode.old;

import java.util.HashMap;

/**
 * @Author: T
 * @Date: 2020/9/7 15:18
 * @Description: 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T387 {
    public static void main(String[] args) {

        String s = "loveleetcode";
        System.out.print(firstUniqChar2(s));

    }

    /**
     * hash + 一次遍历
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> stringIntegerHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            stringIntegerHashMap.put(s.charAt(i), stringIntegerHashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (stringIntegerHashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * int数组优化 捏村
     *
     * @param s
     * @return
     */
    public static int firstUniqChar2(String s) {
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
