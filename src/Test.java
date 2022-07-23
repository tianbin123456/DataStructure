import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.*;

/**
 * @Auther: T
 * @Date: 2019/10/9 16:54
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        MySinglyLinkedList list=new MySinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        //list.remove(2);
        //System.out.println(list.size);
        //System.out.println(list.get(1));
        //int[] a=list.toArray();
        //list.traverse();
        //list.set(0,4);
        //list.traverse();
        //list.printListReversely(list.head);
        System.out.println(list.findBottomK(3));
        System.out.println("!!!!!!!!!");
        HashMap hashMap=new HashMap( );
        new HashSet<>();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        
    }
}
