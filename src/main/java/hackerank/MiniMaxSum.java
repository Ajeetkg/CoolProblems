package hackerank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 */

public class MiniMaxSum {

    static void miniMaxSum(int[] arr) {
        // Complete this function
        arr = sort(arr);
        Long minimum=0l, maximum=0l;
        //assuming the length is 5
        for(int i=0; i < 5; i ++){
            if(i !=4) {
                minimum = minimum + arr[i];
            }
            if( i !=0){
                maximum = maximum + arr[i];
            }
        }
        System.out.print(minimum + " " + maximum);
    }

    //bubble sort
    // Iterate through the array, compare each two element of the array and swap if left > right
    public static int[] sort(int[] inputArray){
        int length = inputArray.length;
        for(int i=0; i < length-1; i++){
            for(int j=0; j < length -i -1; j++ ){
                if(inputArray[j] > inputArray[j+1]){
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = temp;
                }
            }
        }
        return inputArray;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }
}
