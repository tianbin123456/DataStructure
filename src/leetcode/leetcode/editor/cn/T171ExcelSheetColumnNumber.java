//给定一个Excel表格中的列名称，返回其相应的列序号。
//
// 例如， 
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 示例 1: 
//
// 输入: "A"
//输出: 1
// 
//
// 示例 2: 
//
// 输入: "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 输入: "ZY"
//输出: 701 
//
// 致谢： 
//特别感谢 @ts 添加此问题并创建所有测试用例。 
// Related Topics 数学 
// 👍 208 👎 0


package leetcode.leetcode.editor.cn;

public class T171ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Solution solution = new T171ExcelSheetColumnNumber().new Solution();
        System.out.println(solution.titleToNumber("ZY"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String columnTitle) {
//            return solution1(columnTitle);
            return solution2(columnTitle);
        }

        /**
         * 依次计算每一位数，每一位数对应的26的n次方
         */
        private int solution1(String columnTitle) {
            int num = 0;
            for (int i = 0; i < columnTitle.length(); i++) {
                num += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - 1 - i);
            }
            return num;
        }

        /**
         * 所以每遍历一位则ans = ans * 26 + num
         */
        private int solution2(String columnTitle) {
            int ans = 0;
            for (int i = 0; i < columnTitle.length(); i++) {
                int num = columnTitle.charAt(i) - 'A' + 1;
                ans = ans * 26 + num;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}