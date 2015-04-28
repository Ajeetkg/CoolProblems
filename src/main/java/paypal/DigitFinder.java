package paypal;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Ajeet on 3/28/2015.
 */
public class DigitFinder {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //String value = in.nextLine();
       // BigInteger bigInteger = new BigInteger(value);
        long number = in.nextLong();
        int digits = findDigits(number);
        System.out.println(digits);
    }

    private static int findDigits(long number){
        int count=0;

        while(number > 0){
            number = number/10;
            count++;
        }
        return count;
    }

}
