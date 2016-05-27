package Algorithms;

import java.util.Arrays;

/**
 * Created by agupta2 on 5/27/16.
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.

 Example:

 Input: arr[] = {3, 1, 4, 6, 5}
 Output: True
 There is a Pythagorean triplet (3, 4, 5).

 Input: arr[] = {10, 4, 6, 12, 5}
 Output: False
 There is no Pythagorean triplet.



 */
public class PythagoreanTriplets {

    public static void main(String[] args){
        int ar[] = {3, 1, 4, 6, 5};
        int ar_size = ar.length;
        if(isTriplet(ar,ar_size)==true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean isTriplet(int[] ar, int size){

        //for each i, get the next element till the end,
        //for each next element, iterate through thte end to find the sum
        for(int i=0;i< size; i++){
          for( int j=i+1; j<size; j++){
              for( int k=j+1; k<size; k++){
                  int x=ar[i]*ar[i];
                  int y=ar[j]*ar[j];
                  int z=ar[k]*ar[k];

                  if(x==y+z || y==x+z || z==x+y){

                      return true;
                  }
              }
          }

        }


        return false;
    }

    private static boolean isTripletBetter(int[] ar, int size){
        for(int i=0; i<size;i++){
            ar[i] = ar[i]*ar[i];
        }

        // Sort the array
        Arrays.sort(ar);
        for(int lastElementIndex=size-1; lastElementIndex >=2;lastElementIndex--){

            int left=0;
            int right=lastElementIndex-1;

            while(left < right){
                 if(ar[left] + ar[right] ==  ar[lastElementIndex]){
                     return true;
                 }

                if(ar[left] +ar[right] < ar[lastElementIndex]){
                    left++;
                }   else{
                    right++;
                }
            }
        }


        return false;
    }
}
