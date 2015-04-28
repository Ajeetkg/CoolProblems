package multithreading;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Ajeet on 3/22/2015.
 */
public class FutureTaskTest {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CounterIncrementer counterIncrementer = new CounterIncrementer("London");
        List<Future<String>> futures = new ArrayList<Future<String>>();



        for(int i=0;i<15;i++){
            counterIncrementer = new CounterIncrementer("London"+i);
            Future<String> future = executorService.submit(counterIncrementer);
           // future.cancel(true);
            futures.add(future);
        }

        for(Future fut:futures){
            try {
                System.out.println(new Date() + "::" + fut.get());
            }catch(InterruptedException  | ExecutionException ee){
                System.out.println("Two Exceptions caught!!");
            }finally{
                //System.out.println("Finally Executed");
            }
        }

    }

    private static class CounterIncrementer implements Callable<String>{
        private String count="";
        CounterIncrementer(String i){
            this.count = i;
        }
        public String call() throws InterruptedException{
            Thread.sleep(1000);

            Thread.interrupted();
            System.out.println(Thread.interrupted());
            return Thread.currentThread().getName()+count;

        }

        public String getName(){
            return this.count;
        }
    }

    /**
     * "C:\Program Files\Java\jdk1.8.0_40\bin\java" -Didea.launcher.port=7535 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.0.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_40\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\rt.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\zipfs.jar;C:\Users\Ajeet\IdeaProjects\JobSearch\target\classes;C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.0.3\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain multithreading.FutureTaskTest
     Sun Mar 22 13:09:59 PDT 2015::pool-1-thread-1London0
     Sun Mar 22 13:10:00 PDT 2015::pool-1-thread-2London1
     Sun Mar 22 13:10:00 PDT 2015::pool-1-thread-3London2
     Sun Mar 22 13:10:00 PDT 2015::pool-1-thread-2London3
     Sun Mar 22 13:10:01 PDT 2015::pool-1-thread-1London4
     Sun Mar 22 13:10:01 PDT 2015::pool-1-thread-3London5
     Sun Mar 22 13:10:01 PDT 2015::pool-1-thread-1London6
     Sun Mar 22 13:10:02 PDT 2015::pool-1-thread-2London7
     Sun Mar 22 13:10:02 PDT 2015::pool-1-thread-3London8
     Sun Mar 22 13:10:02 PDT 2015::pool-1-thread-3London9
     Sun Mar 22 13:10:03 PDT 2015::pool-1-thread-1London10
     Sun Mar 22 13:10:03 PDT 2015::pool-1-thread-2London11
     Sun Mar 22 13:10:03 PDT 2015::pool-1-thread-2London12
     Sun Mar 22 13:10:04 PDT 2015::pool-1-thread-3London13
     Sun Mar 22 13:10:04 PDT 2015::pool-1-thread-1London14
     */
}
