package Algorithms;

import java.util.Arrays;

/**
 * Created by Ajeet on 3/6/2015.
 */
public class ArraySorter {
    public static void main(String[] args){
        int[] a2={12,15,26,39,42,200};
        int[] a1={14,19,22,37,45,67,78,82,91};
        int[] a3=sortArrays(a1,a2);
        int[] a4 = new int[a1.length+a2.length];

        for (int i : a3) {
            System.out.print(i + ",");
        }


    }

    private static int[] sortArrays(int[] a1, int[] a2){
        //Loop through a1
        //Loop through a2
            //Compare the a1[i] with a2[i]
            //If a2>a1, keep element in the final array; continue;
            // Store last iteratoin point
            //else break
        //a2 loop end
        //if elements are left in a1, iterate and keep all the element.
        int[] a3=new int[a1.length+a2.length];
        int k=0, lastA2=0; boolean smallArrayCompleted = false;
        for(int i=0;i<a1.length;i++){

            if(!smallArrayCompleted){
                for(int j=lastA2;j<a2.length;j++){
                    lastA2=j;

                    if(a1[i]>a2[j]){
                        a3[k]=a2[j];
                        //System.out.print(k+" a2 " + a3[k] +  " lastA2 " +lastA2 +" , ");
                        k++;
                        if(lastA2 == a2.length-1){
                            smallArrayCompleted = true;
                        }

                    }else{
                        break;
                    }

                    //System.out.println(Arrays.asList(a3));
                }
            }
            a3[k]=a1[i];
            //System.out.print(k+" a1 " + a3[k] +" , ");
            k++;
        }

        return a3;
    }
}
