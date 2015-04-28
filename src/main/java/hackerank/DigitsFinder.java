package hackerank;

import java.util.Scanner;

/**
 * Created by Ajeet on 3/27/2015.
 */
public class DigitsFinder {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        int _countNumbers = in.nextInt();
        int _a, count = 0;
        int array[] = new int[_countNumbers];

        while (_countNumbers > 0) {
            _a = in.nextInt();
            array[count] = _a;
            count++;
            _countNumbers--;
        }

        int[] resultArrray = getDigits(array);
        for(int i: resultArrray){
            System.out.println(i);
        }


    }

    private static int[] getDigits(int[] array) {
        int[] result = new int[array.length];
        int count=0;
        for(int i: array){
            result[count] = getDigit(i);
            count++;
        }
        return result;
    }

    private static int getDigit(int number){
        int totalDigits=0;
        int temp, digit;
        temp = number;
        while(temp>0){
            digit = temp%10;

            temp = temp/10;
            if(digit == 0) continue;
            if(number % digit == 0){
                totalDigits ++;
            }
        }
        return totalDigits;
    }
}
