package leetcode.old;

/**
 * @Author: tianbin9611
 * @Date: 2020/9/16 14:51
 * @Description: 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * *       0
 * *      / \
 * *    -3   9
 * *    /   /
 * *  -10  5
 */
public class T108 {
        public static void main(String[] args) {
            int[] nums = {-10, -3, 0, 5, 9};
            TreeNode node = sortedArrayToBST(nums);
            System.out.println(node);
        }


        public static TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        //总是取中值做根节点
        public static TreeNode helper(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            // 总是选择中间位置左边的数字作为根节点
            // 也可以选择右边
            int mid = (left + right) / 2;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, left, mid - 1);
            root.right = helper(nums, mid + 1, right);
            return root;
        }
}
