package leetcode.old;

/**
 * @Author: T
 * @Date: 2020/9/11 18:22
 * @Description: 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T234 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(isPalindrome(node1));
    }

    /**
     * 1.转化为数组， 前后双指针比较。
     * 2.快慢指针，链表一半反转，边遍历边反转，然后比较。
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head,pre,newList=null;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
            pre.next=newList;
            newList=pre;
        }
        //快指针落在最后一个数上，说明有奇数个node，慢指针此时在中位数上，需往后移一位。
        if(fast!=null){
            slow=slow.next;
        }
        while (slow!=null){
            if(slow.val!=newList.val){
                return false;
            }
            slow=slow.next;
            newList=newList.next;
        }
        return true;
    }
}
