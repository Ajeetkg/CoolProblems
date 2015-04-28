package multithreading;

import java.util.concurrent.Semaphore;

/**
 * Created by Ajeet on 3/23/2015.
 */
public class SemaphoresLock {
    int bites=5;
    Semaphore sem1, sem2;


    public static void main(String[] args){
        SemaphoresLock t = new SemaphoresLock();
        Thread t1 = new Thread() { public void run() { t.third(); } };
        Thread t2 = new Thread() { public void run() { t.first(); } };
        Thread t3 = new Thread() { public void run() { t.second(); } };
        Thread t4 = new Thread() { public void run() { t.first(); } };

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }


    public SemaphoresLock(){
        sem1= new Semaphore(1);
        sem2= new Semaphore(1);
    }

    public void first(){
        try{
            sem1.acquire();
            System.out.println("Sempahore1 acquired!"+Thread.currentThread().getName());
            sem1.release();
        }catch(Exception e){

        }
    }

    public void second(){
        try{

            sem1.acquire();
            System.out.println("Sempahore1 acquired!" + Thread.currentThread().getName());
            sem1.release();
            sem2.acquire();
            sem2.release();

        }catch(Exception e){

        }
    }

    public void third(){
        try{
            sem1.acquire();
            sem1.release();
            sem2.acquire();
            System.out.println("Sempahore2 acquired!"+Thread.currentThread().getName());
            sem2.release();
        }catch(Exception e){

        }
    }
}
