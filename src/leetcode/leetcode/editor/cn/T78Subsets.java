//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 996 👎 0


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class T78Subsets {
    public static void main(String[] args) {
        Solution solution = new T78Subsets().new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(solution.subsets2(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        /**
         * 位运算
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            for (int mark = 0; mark < (1 << n); mark++) {
                t.clear();
                for (int i = 0; i < n; i++) {
                    if ((mark & (1 << i)) != 0) {
                        t.add(nums[i]);
                    }
                }
                ans.add(new ArrayList<>(t));
            }
            return ans;
        }


        /**
         * 递归 回溯 先取出完整情况，将计数器+1，递减数字数量，递归变化组成数字。
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets2(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        public void dfs(int cur, int[] nums) {
            if (nums.length == cur) {
                ans.add(new ArrayList<>(t));
                return;
            }
            t.add(nums[cur]);
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            dfs(cur + 1, nums);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}