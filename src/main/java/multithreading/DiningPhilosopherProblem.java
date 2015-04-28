package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * In Dining Philosopher problems, deadlock happens if all the philosopher picks the left chopstick.
 * If A diner has picked the left Chopstick, then only allow him to take the right chopstick.
 * Also, if he doesn't pick the right chopstick, he should leave the left chopstick on the table.
 */
public class DiningPhilosopherProblem {
    public static void main(String[] args) {
        Chopstick left = new Chopstick();
        Chopstick right = new Chopstick();
        Thread t1 = new Thread(new Philosopher(left, right));


        Thread t2 = new Thread(new Philosopher(left, right));
        Thread t3 = new Thread(new Philosopher(left, right));
        Thread t4 = new Thread(new Philosopher(left, right));
        Thread t5 = new Thread(new Philosopher(left, right));

        t1.setName("1");
        t1.setName("2");
        t1.setName("3");
        t1.setName("4");
        t1.setName("5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}

class Philosopher implements Runnable {
    int bite = 10;
    private Chopstick left;
    private Chopstick right;

    Philosopher(Chopstick left, Chopstick right) {

        this.left = left;
        this.right = right;
    }

    public void chew() {
        System.out.println(Thread.currentThread().getName()+", --- "+bite);
        bite--;
    }

    public boolean pickUp() {
        if (!left.pickUp()) {
            return false;
        }
        if (!right.pickUp()) {
            left.putDown();
            return false;
        }
        return true;

    }

    public void putDown() {
        left.putDown();
        right.putDown();
    }

    @Override
    public void run() {
        while (bite > 0) {
            eat();
        }
    }


    public void eat() {
        if (pickUp()) {
            chew();
            putDown();
        }
    }
}

class Chopstick {

    Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    public boolean pickUp() {
        lock.lock();
        return true;

    }

    public void putDown() {
        lock.unlock();
    }

}