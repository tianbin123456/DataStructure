//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1058 👎 0


package leetcode.leetcode.editor.cn;

public class T148SortList {
    public static void main(String[] args) {
        Solution solution = new T148SortList().new Solution();
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
        public ListNode sortList(ListNode head) {
            return function1(head, null);

        }

        /**
         * 归并排序 先拆分 然后合并有序链表
         * @param head
         * @param tail
         * @return
         */
        private ListNode function1(ListNode head, ListNode tail) {
            if (head == null) {
                return head;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }

            ListNode slow = head;
            ListNode fast = head;
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode mid = slow;
            ListNode left = function1(head, mid);
            ListNode right = function1(mid, tail);
            ListNode rst = merge(left, right);
            return rst;
        }

        private ListNode merge(ListNode left, ListNode right) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            ListNode rst = null;
            ListNode root = null;
            while (left != null && right != null) {
                if (left.val > right.val) {
                    if (rst == null) {
                        rst = right;
                        root = right;
                    } else {
                        rst.next = right;
                        rst = rst.next;
                    }
                    right = right.next;
                } else {
                    if (rst == null) {
                        rst = left;
                        root = left;
                    } else {
                        rst.next = left;
                        rst = rst.next;
                    }
                    left = left.next;
                }
            }
            if (left != null) {
                rst.next = left;
            }
            if (right != null) {
                rst.next = right;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}