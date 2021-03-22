//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1218 👎 0


package leetcode.leetcode.editor.cn;


import java.util.*;

public class T23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new T23MergeKSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
//            return function(lists);
            return function2(lists);

        }

        /**
         * 分治
         *
         * @param lists
         * @return
         */
        private ListNode function2(ListNode[] lists) {
            int length = lists.length;
            int start = 0;
            int end = length - 1;
            if (length == 0) {
                return null;
            }
            if (length == 1) {
                return lists[0];
            }
            return fenzhi(lists, start, end);
        }

        private ListNode fenzhi(ListNode[] lists, int start, int end) {
            if (end == start) {
                return lists[start];
            }
            int mid = start + ((end - start) >> 1);
            ListNode left = fenzhi(lists, start, mid);
            ListNode right = fenzhi(lists, mid + 1, end);
            return merge(left, right);
        }

        //合并顺序链表
        private ListNode merge(ListNode left, ListNode right) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            ListNode rst=null;
            ListNode root=null;
            while (left!=null&&right!=null){
                if(left.val> right.val){
                    if(rst==null){
                        rst=right;
                        root=right;
                    }else {
                        rst.next=right;
                        rst=rst.next;
                    }
                    right=right.next;
                }else {
                    if(rst==null){
                        rst=left;
                        root=left;
                    }else {
                        rst.next=left;
                        rst=rst.next;
                    }
                    left=left.next;
                }
            }
            if(left!=null){
                rst.next=left;
            }
            if(right!=null){
                rst.next=right;
            }
            return root;
        }

        /**
         * 最小堆
         *
         * @param lists
         * @return
         */
        private ListNode function(ListNode[] lists) {
            Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
            ListNode rst = null;
            ListNode root = null;
            for (ListNode node : lists) {
                while (node != null) {
                    queue.offer(node.val);
                    node = node.next;
                }
            }
            while (queue.peek() != null) {
                if (rst == null) {
                    rst = new ListNode(queue.poll());
                    root = rst;
                } else {
                    rst.next = new ListNode(queue.poll());
                    rst = rst.next;
                }
            }
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}