package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ajeet on 3/23/2015.
 */
public class ThreadInOrder {
    Lock lock1, lock2;
    public ThreadInOrder(){
         lock1=new ReentrantLock();
         lock2= new ReentrantLock();

        lock1.lock();
        lock2.lock();
    }

    public void first(){
        lock1.lock();
    }
    public void second(){
        lock1.lock();
        System.out.println("second");
        lock1.unlock();
    }

    public void third(){
        lock1.lock();
        lock2.lock();
        System.out.println("third");
        lock2.unlock();
    }
}
