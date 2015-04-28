package multithreading;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Ajeet on 3/22/2015.
 */
public class FutureTaskTest2 {

    public static void main(String[] args){

        CounterIncrementer counterIncrementer1 = new CounterIncrementer("Rohini");
        CounterIncrementer counterIncrementer2 = new CounterIncrementer("Ajeet");
        CounterIncrementer counterIncrementer3 = new CounterIncrementer("Ajeet1");
        CounterIncrementer counterIncrementer4 = new CounterIncrementer("Ajeet2");
        CounterIncrementer counterIncrementer5 = new CounterIncrementer("Ajeet3");

        FutureTask<String> futureTask1 = new FutureTask<String>(counterIncrementer1);
        FutureTask<String> futureTask2 = new FutureTask<String>(counterIncrementer2);
        FutureTask<String> futureTask3 = new FutureTask<String>(counterIncrementer3);
        FutureTask<String> futureTask4 = new FutureTask<String>(counterIncrementer4);
        FutureTask<String> futureTask5 = new FutureTask<String>(counterIncrementer5);
        FutureTask<String> futureTask6 = new FutureTask<String>(counterIncrementer2);


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(futureTask3);
        executorService.submit(futureTask4);
        executorService.submit(futureTask5);
        executorService.submit(futureTask2);
        executorService.submit(futureTask1);


        while(true){
            System.out.println(Thread.currentThread().getName());
            if(futureTask1.isDone() && futureTask2.isDone()){
                System.out.println("Both thread completed");
                executorService.shutdownNow();
                return;
            }

            try {
                if (!futureTask3.isDone()) {
                    //Wait for task to complete
                    System.out.println("Thread3 is not completed" + futureTask3.get());
                }

                if (!futureTask1.isDone()) {
                    //Wait for task to complete
                    System.out.println("Thread1 is not completed" + futureTask1.get());
                }

                if (!futureTask2.isDone()) {
                    //Wait for task to complete
                    System.out.println("Thread2 is not completed" + futureTask2.get());
                }
            }catch(InterruptedException | ExecutionException ee){
                ee.printStackTrace();
            }
/**
 * "C:\Program Files\Java\jdk1.8.0_40\bin\java" -Didea.launcher.port=7536 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.0.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_40\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\rt.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\zipfs.jar;C:\Users\Ajeet\IdeaProjects\JobSearch\target\classes;C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.0.3\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain multithreading.FutureTaskTest2
 main
 Thread3 is not completedpool-1-thread-1Ajeet1
 Thread1 is not completedpool-1-thread-1Rohini
 main
 Both thread completed

 Process finished with exit code 0
 */
        }




    }

    private static class CounterIncrementer implements Callable<String>{
        private String count="";
        CounterIncrementer(String i){
            this.count = i;
        }
        public String call() throws InterruptedException{
            Thread.sleep(1000);
            return Thread.currentThread().getName()+count;

        }

        public String getName(){
            return this.count;
        }
    }


}
