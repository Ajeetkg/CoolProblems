package hackerank;

import java.util.Scanner;

/**
 * Created by Ajeet on 4/5/2015.
 */
public class FizzBuzz {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */



        System.out.println(divide(2,3));
        System.out.println(divide(4,3));
        System.out.println(divide(6,3));
        System.out.println(divide(10,3));

        System.out.println(divide(1,4));

        System.out.println(divide(-2,-3));
        System.out.println(divide(-2,3));

        System.out.println(divide(2,-3));

        /*
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        for (int i = 1; i <= number; i++) {
            fizzbuzz1(i);
        }*/

    }

    private static void fizzbuzz1(int number) {

        if (number % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else {
            System.out.println(number);
        }
    }

    public static int divide(int numerator, int denominator) throws ArithmeticException {

        // check if the numerator is greater than denominator, if no, return 0;
        // else… subtract denominatior from numerator, increase the quotient count by 1
        // do it recursively till numerator is greater than denominator. return the count;
        int quotient = 0;
        boolean isNegative = false;
        if (denominator == 0) {
            throw new ArithmeticException();
        }
        if (numerator < 0 || denominator < 0){

            if(numerator <0 && denominator <0){
                isNegative=false;
            }
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
            isNegative = true;
        }
        if (numerator < denominator) {
            return quotient;
        } else {
            while (numerator >= denominator) {
                numerator = numerator - denominator;
                quotient++;
            }
        }
        if (isNegative) {
            quotient = -quotient;
        }
        return quotient;
    }
}
