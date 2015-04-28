package hackerank;

import java.util.Scanner;

/**
 * Created by Ajeet on 4/12/2015.
 */
public class NextPalindromeFinder {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int value=in.nextInt();
        long[] number = new long[value];
        int count = 0;
        while(value > 0){
            number[count] = in.nextLong();
            count++;
            value--;
        }
        for(long i: number){
            //System.out.println(", " + i);
            System.out.println(getPalindrome(i));
        }


    }

    private static long[] getPalindromes(long[] number){
        long[] palindromes = new long[number.length];
        int count=0;
        for(long num:number){
            palindromes[count] = getPalindrome(num);
            count++;
        }

        return palindromes;
    }

    /**
     * if the number is
     * 123456 = 123321 --> Wrong answer
     *  incresae the middle number 1
     *   123456 -> 124421 --> increase the count of the substring by 1, and reverse it.
     *   12345 --> 12321 --> wrong answer
     *   12421 --> right answer, increase the middle digit by 1.
     *
     * 654321 = 654456 --> correct Answer
     * @param number
     * @return
     */
    private static long getPalindrome(long number){
        long palindrome =0;
        long[] splitNumbers= new long[2];
        long oddDigit=0;
        int numLength=getNumDigits(number);

        if(numLength%2 == 0 ){
            splitNumbers =  getSplitNumber((numLength-1)/2,number);
        }else{
            splitNumbers = getSplitNumber((numLength-1)/2-1,number);
            oddDigit = splitNumbers[0]%10;
            splitNumbers[0] = splitNumbers[0]/10;
        }
        if(splitNumbers[0]<splitNumbers[1]){
            if(numLength%2 == 0){
                splitNumbers[0]=splitNumbers[0]+1;
            }else{
                oddDigit=oddDigit+1;
            }
        }
        long reversed=getReverse(splitNumbers[0]);
        return formatPalindrome(splitNumbers,oddDigit,reversed);
    }
    private static long formatPalindrome(long[] splitNumbers, long oddDigit, long reversed){
        String reversedString;
        if(oddDigit == 0) {
            reversedString = splitNumbers[0] + "" + reversed;
        }else{
            reversedString = splitNumbers[0]+""+oddDigit+""+reversed;
        }
        return Long.parseLong(reversedString);
    }

    private static int getNumDigits(long number){
        int numDigits=0;
        while(number > 0){
            number = number/10;
            numDigits++;
        }
        return numDigits;
    }

    private long changedNumber(long number){

        return 0;
    }
    private static long[] getSplitNumber(int index, long number){
        //System.out.println("Number is: "+number+", index is:"+index);
        long[] splitNumberArray=new long[2];
        long splitNumber=0;
        long digit=0;
        long iteration=1;
        while(number > 0){
            digit=number%10;
            splitNumber=splitNumber + digit*iteration;
            iteration = iteration*10;
            number = number/10;

            if(index == 0){
                splitNumberArray[1]=splitNumber;
                splitNumber =0;
                iteration=1;
            }
            index--;

        }
        splitNumberArray[0] = splitNumber;
        return splitNumberArray;
    }

    private static long getReverse(long number){
        long reversedNumber=0;
        long digit=0;
        while(number > 0){
            digit = number%10;
            reversedNumber = reversedNumber*10+digit;
            number = number/10;
        }
        return reversedNumber;
    }
}
