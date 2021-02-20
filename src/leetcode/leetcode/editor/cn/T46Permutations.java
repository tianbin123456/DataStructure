//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1138 👎 0


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T46Permutations {
    public static void main(String[] args) {
        Solution solution = new T46Permutations().new Solution();
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution.permute(nums));
    }

    /**
     * 全排列
     * 依次放入每个位置的数
     * 全放入后则产生一个解
     * 递归回溯上一步取新值放入
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> rst = new ArrayList<>();
            List<Integer> out = new ArrayList<>();
            for (int num : nums) {
                out.add(num);
            }
            recursive(rst, out, nums.length, 0);
            return rst;
        }

        private void recursive(List<List<Integer>> rst, List<Integer> out, int n, int m) {
            if (n == m) {
                rst.add(new ArrayList<>(out));
            }
            for (int i = m; i < n; i++) {
                Collections.swap(out, m, i);
                recursive(rst, out, n, m + 1);
                Collections.swap(out, m, i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
