package coreJava;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Ajeet on 3/5/2015.
 */
public class LambdaFunctionsTest {
    public static void main(String[] args){
        String[] names={"ancd","abcdde","abcdefedweds","abcddesrewrerewwerw","ab","abd"};
        String[] names1={"ancd","abcdde","abcdefedweds","abcddesrewrerewwerw","ab","abd"};
        Arrays.sort(names, TestStatic::compareByLength);
        System.out.println(Arrays.asList(names));

        Arrays.parallelSort(names1, TestStatic::compareByLength);
        System.out.println(Arrays.asList(names1));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2014);
        calendar.set(Calendar.MONTH,10);

        Calendar calendar1= new Calendar.Builder().set(Calendar.YEAR,2014).build();

        System.out.println(calendar);
        System.out.println(calendar1);

        List<String> lists = Arrays.asList(names);
        lists.forEach(str -> System.out.println(str+"\t"));


    }
}

class TestStatic{
    public static int compareByLength(String in, String out){
        return in.length() - out.length();
    }
}


