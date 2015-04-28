package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Ajeet on 3/5/2015.
 */
public class ThreadExecutorFramework {

    private static ExecutorService executorService;
    private static Future taskOneResults;
    private static Future taskTwoResults;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(1);
        while (true) {
            try {
                checkTask();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Caught checkTask Exception");
            } finally {
                System.out.println("Caught checkTaskFinally Exception");
            }
        }
    }

    private static void checkTask() {
        if (taskOneResults == null
                || taskOneResults.isDone() || taskOneResults.isCancelled()) {
            taskOneResults = executorService.submit(new TaskOne());
        }

        if (taskTwoResults == null
                || taskTwoResults.isDone() || taskTwoResults.isCancelled()) {
            taskTwoResults = executorService.submit(new TaskTwo());
        }
    }
}

class TaskOne implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("Running taskOne");
            } catch (Exception e) {
                System.out.println("Caught 1 Exception");
            } finally {

            }
        }

    }
}

class TaskTwo implements Runnable {

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("Running taskTwo");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Caught 2 Exception");
            } finally {
            }
        }

    }
}
