package multithreading;

import java.util.concurrent.Semaphore;

/**
 * There are three methods, Thread1 access method1, Trhead2 access method2, Thread3 access method3.
 * Now, we want that the method should be executed in the order 3,2,1
 *
 * For this, first create Semaphore, sem1, sem2. Get lock on both the semaphore in the constructor.
 * now, the method which you want to execute first, go there and release lock on that... So, any thread
 * which access to that method will be executed. Next, release lock in the second method which you want to execute.
 * Lastly, the third method would be executed.
 */
public class MethodInSequence {

    public static void main(String[] args){
        MethodType methodType = new MethodType();
        Thread t1 = new Thread(){
            public void run(){
                    System.out.println("Name    :   "+Thread.currentThread().getName());
                  methodType.method1();
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                System.out.println("Name    :   "+Thread.currentThread().getName());
                methodType.method2();
            }
        };
        Thread t3 = new Thread(){
            public void run(){
                System.out.println("Name    :   "+Thread.currentThread().getName());
                methodType.method3();
            }
        };
        t1.setName("T1  ");
        t2.setName("T2  ");
        t3.setName("T3  ");

        t1.start();
        t2.start();
        t3.start();



    }
}

class MethodType {

    Semaphore sem1, sem2;

    public MethodType(){
        sem1 = new Semaphore(1);
        sem2= new Semaphore(1);

        try{
            sem1.acquire();
            sem2.acquire();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }

    }

    public void method1(){
        System.out.println("method1");
        try{

        }catch(Exception e){

        }

    }

    public void method2(){
        System.out.println("method2");
        try{
            sem2.release();
        }catch(Exception e){

        }
    }

    public void method3(){
        System.out.println("method3");
        try{
            sem1.release();
        }catch(Exception e){

        }
    }
}
