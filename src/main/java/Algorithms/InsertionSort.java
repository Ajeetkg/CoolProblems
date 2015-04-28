package Algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ajeet on 3/7/2015.
 */
public class InsertionSort {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minElm = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minElm = j;
                }
            }
            swap(arr, i, minElm);
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean bool = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (j + 1 < arr.length && arr[j] > arr[j + 1]) {
                    bool = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!bool) break;
        }
    }

    public static void main(String... args) throws Exception {
        Random r = new Random(1);
        int SIZE = 30;
        int N = 1000;
        int[] arr = new int[SIZE];
        int[] millisBubble = new int[N];
        int[] millisInsertion = new int[N];
        System.out.println("start");
        //warm up:
        for (int t = 0; t < 100; t++) {
            insertionSort(arr);
        }
        for (int t = 0; t < N; t++) {
            arr = generateRandom(r, SIZE);
            int[] tempArr = Arrays.copyOf(arr, arr.length);

            long start = System.nanoTime();
            insertionSort(tempArr);
            millisInsertion[t] = (int) (System.nanoTime() - start);

            tempArr = Arrays.copyOf(arr, arr.length);

            start = System.nanoTime();
            bubbleSort(tempArr);
            millisBubble[t] = (int) (System.nanoTime() - start);
        }
        int sum1 = 0;
        for (int x : millisBubble) {
            System.out.println(x);
            sum1 += x;
        }
        System.out.println("end of bubble. AVG = " + ((double) sum1) / millisBubble.length);
        int sum2 = 0;
        for (int x : millisInsertion) {
            System.out.println(x);
            sum2 += x;
        }
        System.out.println("end of insertion. AVG = " + ((double) sum2) / millisInsertion.length);
        System.out.println("bubble took " + ((double) sum1) / millisBubble.length + " while insertion took " + ((double) sum2) / millisBubble.length);
    }

    private static int[] generateRandom(Random r, int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = r.nextInt(size);
        return arr;
    }
}
