package multithreading;

/**
 * Created by Ajeet on 3/19/2015.
 */
public class ReturnValueFromThread {

    private  int result;

    public static void main( String[] args) throws InterruptedException {

        new ReturnValueFromThread().runTest();
    }

    private void runTest() throws InterruptedException {

        Thread thread = new Thread() {

            public void run() {

                System.out.println("Thread starts");

                try {
                    // some long operation in your thread
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread ends");

                // set the value you want to "produce" with your thread
                setResult(42);

                // notify waiting threads
                synchronized (this) {
                    notify();
                }
            }
        };

        // start your thread
        thread.start();

        // wait for it
        synchronized (thread) {
            thread.wait();
        }

        // now you got your result
        System.out.println("result = " + result);
    }

    void setResult(int value) {
        this.result = value;
    }
}