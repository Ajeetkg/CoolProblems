package Algorithms;

import java.util.Arrays;

/**
 * Created by Ajeet on 3/21/2015.
 */
public class IndexFinder {

    public static void main(String[] args) {
        int[] array = {3, 8,12, 15, 23, 45};
        findIndexO2(array, 20);
        findIndexN(array, 20);
    }

    //basic method
    private static int[] findIndexO2(int[] array, int sum) {
        int a[] = new int[2];
        int firstIndex, secondIndex, tempSum;
        for (int i = 0; i < array.length; i++) {
            firstIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                secondIndex = j;
                tempSum = array[i] + array[j];
                if (tempSum == sum) {
                    a[0] = firstIndex;
                    a[1] = secondIndex;
                    System.out.println("firstIndex:" + firstIndex + ", secondIndex:" + secondIndex);
                    return a;
                }
            }
        }
        return a;
    }

    //bettermethod
    private static int[] findIndexN(int[] array, int sum) {
        int a[] = new int[2];
        int aa[][] = new int[5][2];
        int tempSum, secondIndex, firstIndex = 0;
        Arrays.sort(array);
        int i=0;
        secondIndex=array.length-1;
        while (firstIndex < secondIndex) {
            tempSum = array[firstIndex] + array[secondIndex];
            if(tempSum < sum){
                firstIndex++;
            }
            if (tempSum > sum) {
              secondIndex--;
            }
            if(tempSum == sum){
                a[0]=firstIndex;
                a[1]=secondIndex;
                System.out.println("firstIndex:" + firstIndex + ", secondIndex:" + secondIndex);
                aa[i]=a;
                i++;
                firstIndex++;
            }
        }
        return a;
    }

    //anotheralternateive
    private static int[] findIndexUsingMap(int[] array, int sum) {
        int a[] = new int[2];
        int tempSum;


        return a;
    }
}
