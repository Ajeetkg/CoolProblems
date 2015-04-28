package paypal;

/**
 * Created by Ajeet on 4/7/2015.
 */
public class PrimeNumberFinder {

    private static boolean optimizedIsPrime(int number) {
        if (number < 2) return false;
        if (number % 2 == 0) return false;
        int sqrt = (int) getSqrt(number);
        boolean isPrime = true;
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return true;
    }

    private static double getSqrt(int number) {
        return Math.sqrt(number);
    }

    private static int getNextPrime(int number) {
        //Condition to check if the number is negative
        if (number < 2) {
            return 2;
        }
        boolean tempPrimeStatus = false;
        while (true) {
            tempPrimeStatus = optimizedIsPrime(number);
            if (tempPrimeStatus == true) {
                return number;
            }
            number++;
        }

    }

    private boolean isPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

}
