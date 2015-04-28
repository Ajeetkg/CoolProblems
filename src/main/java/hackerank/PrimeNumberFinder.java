package hackerank;

import java.util.Scanner;

/**
 * Created by Ajeet on 4/5/2015.
 */
public class PrimeNumberFinder {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        //System.out.println(getNumberOfPrimes(number));
        System.out.println(printNum(number));
    }

    private static int printNum(int upperLimit){

        for(int i=2;i < upperLimit;i++){
           System.out.println(i);
        }

        return upperLimit;
    }

    private static int getNumberOfPrimes(int upperLimit){
        int primeCount=3;
        for(int i=2;i < upperLimit;i++){
            if(isPrime(i)){
                primeCount++;
            }
        }

        return primeCount;
    }

    private static boolean isPrime(int num){
        if(num % 2 == 0) return false;
        if(num % 3 == 0) return false;
        if(num % 5 == 0) return false;
        for( int i=5; i < (num/2); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
