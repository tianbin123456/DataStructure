package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: tianbin9611
 * @Date: 2020/9/15 17:16
 * @Description: 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * *  5
 * * / \
 * *1   4
 * *   / \
 * *  3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class T98 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(isValidBST2(node1));
    }


    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 递归 分解为左右子树的范围值问题
     *
     * @param root
     * @return
     */
    public static boolean isValidBST2(TreeNode root) {
        return digui(root, null, null);
    }

    /**
     * 递归
     *
     * @param cur
     * @param lower
     * @param upper
     * @return
     */
    public static boolean digui(TreeNode cur, Integer lower, Integer upper) {
        if (cur == null) {
            return true;
        }
        int val = cur.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!digui(cur.left, lower, val)) {
            return false;
        }
        if (!digui(cur.right, val, upper)) {
            return false;
        }
        return true;
    }
}
