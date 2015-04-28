package paypal;

import java.util.Arrays;

/**
 * Created by Ajeet on 4/7/2015.
 * You are given a huge list of integer and you need to find the top 10 elements from that list.
 * How will you go ahead? You cannot use the sorting logic because that would be time consumeing... 1M*1M.
 * Maximum it should be order of N.
 */
public class Top100RecordsFinder {
    public static void main(String[] args){
        int[] array = createRandomArray();
        getTopTen(array);


    }

    private static int[] getTopTen(int[] array){
        int[] finalArray = new int[10];
        finalArray = Arrays.copyOfRange(array,0,10);
        Arrays.sort(finalArray);
        for(int val: finalArray){
                System.out.print("  "+val);
        }
        for(int i=10; i< array.length;i++){
            if(array[i] > finalArray[0]){
                finalArray[0]=array[i];
                Arrays.sort(finalArray);
            }
        }
        System.out.println();
        for(int val: finalArray){
            System.out.print("  "+val);
        }
        return finalArray;
    }
    private static int[] createRandomArray(){
        int[] randomArray = new int[1000];
        int element=0;
        int min=100, max=5000000;
        for(int i=0; i <1000; i++){
            element = min+(int)(Math.random()*(max-min));
            randomArray[i]=element;
        }
        return randomArray;
    }
}
