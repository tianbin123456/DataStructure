import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 * @Auther: T
 * @Date: 2019/10/9 16:44
 * @Description:
 */
public class MySinglyLinkedList {
    int size=0;
    Node head=null;
    private class Node{
        int data;
        Node next;
        private Node(){

        }
        private Node(int data){
            this.data=data;
        }
        private  Node(int data, Node next){
            this.data=data;
            this.next=next;
        }
    }

    void add(int data){
        size++;
        Node temp=head;
        if(null==temp){
            head=new Node(data);
        }else {
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=new Node(data);
        }
    }

    int get(int index){
        if(!checkIndex(index)){
            throw new IndexOutOfBoundsException();
        }else {
            Node temp=head;
            for (int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp.data;
        }
    }

    void remove(int index){

        if(!checkIndex(index)){
            throw new IndexOutOfBoundsException();
        }else {
            Node temp=head;
            Node front=null;
            if(index==0){
                head=head.next;
            }else {
                for (int i=0;i<index;i++){
                    front=temp;
                    temp=temp.next;
                }
                front.next=temp.next;
            }
        }
        size--;
    }

    private boolean checkIndex(int index){
        return index>=0&&index<size;
    }

    int[] toArray(){
        int[] array=new int[size];
        Node temp=head;
        for (int i=0;i<size;i++){
            array[i]=temp.data;
            temp=temp.next;
        }
        return array;
    }
}
