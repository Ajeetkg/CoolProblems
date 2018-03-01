package Algorithms;

import java.util.Scanner;

/**
 * Created by testmac on 2/28/18.
 */


public class BubbleSort {


    public static void main(String[] args){
        System.out.print("Enter the number of elements: ");

        Scanner in = new Scanner(System.in);
        int arraySize = in.nextInt();
        System.out.println();
        int[] array = new int[arraySize];
        System.out.println("Enter the array elements");
        for(int i=0; i < arraySize; i++){
            array[i] = in.nextInt();
        }
        print(array);

        sort(array);
        System.out.println();
        print(array);
    }

    /*
      Iterate on the array{
        Compare two adjacent elements of the array, if the left > right, swap;
       }
     */
    private static int[] sort(int[] array){
        int length = array.length;

        for(int i=0; i< length-1; i++){
            for(int j=0; j< length -i -1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array [j+1];
                    array[j+1]= temp;
                }
            }
        }
        return array;
    }

    private static void print(int[] array){
        System.out.print("Array: { ");
        for(int i=0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.print(" }");
    }
}
