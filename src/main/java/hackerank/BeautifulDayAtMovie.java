package hackerank;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
public class BeautifulDayAtMovie {

    static int beautifulDays(int i, int j, int k) {
        // Complete this function
        int numberOfBeautifulDays = 0;
        int startDay = i;
        int endDay = j;
        for (startDay = i; startDay <= endDay; startDay++) {
            int reversedDay = reversed(startDay);
            int absoluteDifference = Math.abs(startDay - reversedDay);
            if(absoluteDifference%k == 0){
                numberOfBeautifulDays++;
            }
        }
        return numberOfBeautifulDays;
    }

    //423
    private static int reversed(int day) {
        int reversedDay = 0, multiplier = 10;
        while (day % 10 > 0 || day/10 > 0) {
            int quotient = day % 10;
            reversedDay = reversedDay * multiplier + quotient;
            day = day / 10;
        }
        return reversedDay;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int result = beautifulDays(i, j, k);
        System.out.println(result);
        in.close();
    }
}

