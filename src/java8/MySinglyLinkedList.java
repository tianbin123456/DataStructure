package java8;

/**
 * @Auther: T
 * @Date: 2019/10/9 16:44
 * @Description: 自定义单向链表
 */
public class MySinglyLinkedList {
    int size = 0;
    Node head = null;

    private class Node {
        int data;
        Node next;

        private Node() {

        }

        private Node(int data) {
            this.data = data;
        }

        private Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //尾接点添加
    void add(int data) {
        size++;
        Node temp = head;
        if (null == temp) {
            head = new Node(data);
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }

    //获取指定位置节点值
    int get(int index) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    //指定位置设值
    void set(int index, int data) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            Node temp = head;
            if (index == 0) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                head = newNode;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                Node newNode = new Node(data);
                newNode.next = temp.next.next;
                temp.next = newNode;
            }
        }
    }

    //删除
    void remove(int index) {

        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            Node temp = head;
            Node front = null;
            if (index == 0) {
                head = head.next;
            } else {
                for (int i = 0; i < index; i++) {
                    front = temp;
                    temp = temp.next;
                }
                front.next = temp.next;
            }
        }
        size--;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    //toArray
    int[] toArray() {
        int[] array = new int[size];
        Node temp = head;
        for (int i = 0; i < size; i++) {
            array[i] = temp.data;
            temp = temp.next;
        }
        return array;
    }

    //遍历输出
    void traverse() {
        Node temp = head;
        while (null != temp) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    //反转打印
    void printListReversely(Node head) {
        Node temp = head;
        /*if(null==temp.next){
            System.out.println(temp.data);
        }else {
            printListReversely(temp.next);
            System.out.println(temp.data);
        }*/
        if (null != temp) {
            printListReversely(temp.next);
            System.out.println(temp.data);
        }
    }

    //找到倒数第k个数 快慢指针
    int findBottomK(int k) {
        if (k > size || k < 1) {
            throw new IndexOutOfBoundsException();
        }
        Node temp1 = head;
        Node temp2 = head;
        for (int i = 0; i < k; i++) {
            temp1 = temp1.next;
        }
        while (null != temp1) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp2.data;
    }

    //快慢指针判断是否有环和环入口
    Node findLoop() {
        Node slow = head;
        Node fast = head;
        while (null != fast || null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow==fast) {
                break;
            }
        }
        if (null != fast || null != fast.next){
            return null;
        }
        fast=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
        /*计算环大小
        int size = 1;
        fast = fast->pNext->pNext;
        slow = slow->pNext;
        while(fast != slow)
        {
            ++size;
            fast = fast->pNext->pNext;
            slow = slow->pNext;
        }

        return size;*/
    }
}
