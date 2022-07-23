package leetcode.leetcode.editor.cn;

/**
 * @Author: tianbin9611
 * @Date: 2020/9/15 13:25
 * @Description:
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
