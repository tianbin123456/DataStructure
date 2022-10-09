/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 按 严格递增 顺序排列
 * <p>
 * <p>
 * Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 1153 👎 0
 */

package leetcode.leetcode.editor.cn;

import java.util.Arrays;

public class T108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new T108ConvertSortedArrayToBinarySearchTree().new Solution();
        int[] num = {1, 2, 3};
        solution.sortedArrayToBST(num);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            int length = nums.length;
            TreeNode treeNode = new TreeNode();
            if (length == 1) {
                treeNode.val = nums[0];
            } else if (length == 2) {
                treeNode.val = nums[0];
                TreeNode right = new TreeNode();
                right.val = nums[1];
                treeNode.right = right;
            } else {
                int i = length / 2;
                treeNode.val = nums[i];
                int[] leftNums = Arrays.copyOfRange(nums, 0, i);
                TreeNode left = sortedArrayToBST(leftNums);
                int[] rightNums = Arrays.copyOfRange(nums, i + 1, length);
                TreeNode right = sortedArrayToBST(rightNums);
                treeNode.left = left;
                treeNode.right = right;
            }
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}