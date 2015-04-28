package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by Ajeet on 3/19/2015.
 */
public class TestThreadException {

    public static void main(String[] arg) {
        Thread t1 = new Thread(new ThreadExample());
        t1.start();
        TestThreadException testThreadException = new TestThreadException();

        Runnable rn = new ThreadExample();

        //How to use the Callable
        Callable<Integer> callable = new AnotherThreadExample(2);

        ExecutorService executor = new ScheduledThreadPoolExecutor(5);
        Future<Integer> future = executor.submit(callable);
        Future integerFuture = executor.submit(rn);
        Future<Integer> anotherFuture = executor.submit(rn, 1);

        try {
            System.out.println("Future value: " + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ThreadExample implements Runnable {
    private String name = "ThreadExample";

    public void run() {
        while (true) {
            System.out.println("Running: " + this.name);
            methodA();
        }
    }

    private void methodA() {
        int x = 0;
        int y = 4 / x;
    }
}

class AnotherThreadExample implements Callable<Integer> {

    private int myName;

    AnotherThreadExample(int i) {
        myName = i;
    }

    public Integer call() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread : " + getMyName() + " I is : " + i);
        }
        return new Integer(getMyName());

    }

    public int getMyName() {
        return myName;
    }

    public void setMyName(int myName) {
        this.myName = myName;
    }

}
