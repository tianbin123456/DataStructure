package leetcode.old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: tianbin9611
 * @Date: 2020/9/16 14:17
 * @Description: 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * *   3
 * *  / \
 * * 9  20
 * *   /  \
 * *  15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * *   [3],
 * *   [9,20],
 * *  [15,7]
 * ]
 */
public class T102 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        List<List<Integer>> lists = levelOrder(node1);
    }

    /**
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            ArrayList<Integer> integers = new ArrayList<>();
            while (size > 0) {
                TreeNode node = treeNodes.poll();
                size--;
                integers.add(node.val);
                if (node.left != null) {
                    treeNodes.offer(node.left);
                }
                if (node.right != null) {
                    treeNodes.offer(node.right);
                }
            }
            lists.add(integers);
        }
        return lists;
    }


}
