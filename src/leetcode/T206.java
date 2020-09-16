package leetcode;


/**
 * @Author: T
 * @Date: 2020/9/9 18:38
 * @Description: 206 反转链表
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class T206 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node2.next = node3;
        node1.next = node2;
        node3.next = node4;
        node4.next = node5;
        ListNode head = node1;
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("");
        ListNode node6 = reverseList2(node1);
        ListNode head2 = node6;
        while (head2 != null) {
            System.out.print(head2.val + "->");
            head2 = head2.next;
        }
    }

    /**
     * 迭代 双指针
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode curNode = head;
        ListNode newNode = null;
        while (curNode != null) {
            ListNode temp = curNode.next;
            curNode.next = newNode;
            newNode = curNode;
            curNode = temp;
        }
        return newNode;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {

        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList2(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

}

