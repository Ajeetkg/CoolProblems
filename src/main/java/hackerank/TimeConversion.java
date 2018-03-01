package hackerank;

/**
 * Created by testmac on 2/28/18.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/time-conversion/problem
 */
public class TimeConversion{

    static String timeConversion(String s) {
        // Complete this function
        String output = null;
        String[] time = s.split(":");
        String amPm = time[2].substring(2);
        time[2] = time[2].substring(0,2);
        if(Integer.parseInt(time[0]) == 12 && amPm.equalsIgnoreCase("AM")){
            time[0] = "00";
        }
        if(Integer.parseInt(time[0]) != 12 && amPm.equalsIgnoreCase("PM")){
            int hoursTime = Integer.parseInt(time[0])+12;
            time[0] = hoursTime+"";
        }
        output = time[0]+":"+time[1]+":"+time[2];
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
