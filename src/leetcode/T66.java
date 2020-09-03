package leetcode;

/**
 * @Author: T
 * @Date: 2020/9/3 09:12
 * @Description: T66
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T66 {


    public static void main(String[] args) {
        int[] a = {4, 3, 2, 1};
        int[] ints = plusOne2(a);
        for (int x : ints) {
            System.out.print(x + ",");
        }
    }

    /**
     * 循环有进位 继续前一个数值的加一 无进位直接返回
     * 循环结束说明是全有进位的情况 99/999 直接新建 首位为1的新数组
     *
     * @param digits
     * @return
     */
    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * error 数组过长会超出int值范围
     *
     * 转换为数字，加一，再转换为数组
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int start = 0;
        for (int i = 0; i < digits.length; i++) {
            start += digits[i] * Math.pow(10, digits.length - 1 - i);
        }
        start++;
        String end = String.valueOf(start);
        String[] split = end.split("");
        int[] rst = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            rst[i] = Integer.parseInt(split[i]);
        }
        return rst;
    }


}
