import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: T
 * @Date: 2019/10/10 13:51
 * @Description:
 */
public class MyQueue{
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue myQueue=new ArrayBlockingQueue(10);
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.put(4);
        System.out.println(myQueue.take());
        System.out.println(myQueue.take());
        System.out.println(myQueue.take());
        System.out.println(myQueue.take());
        LinkedBlockingQueue linkedBlockingQueue=new LinkedBlockingQueue(10);
    }


}
