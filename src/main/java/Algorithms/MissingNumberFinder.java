package Algorithms;

/**
 * Created by Ajeet on 3/7/2015.
 */
public class MissingNumberFinder {
    public static void main(String[] args){
        int[] a1={2,5,8,14,17,20,23,26};
        int diff=(a1[0]+a1[a1.length-1])/5;

        int indx=findMissing(a1);
        System.out.println(indx+", value="+(a1[0]+(indx+1)*diff));
        indx = findMissingBinary(a1, 0, a1.length);
        System.out.println(indx+", value="+(a1[0]+(indx+1)*diff));
    }

    private static int findMissing(int[] array){
        for(int i=1;i<array.length-2;i++){
            if(array[i]-array[i-1] == array[i+1]-array[i]){
                continue;
            }else
                return i;
        }
        return 0;
    }

    private static int findMissingBinary(int[] array, int low, int high){
        int mid=low+(high-low)/2;

        if(array[mid]-array[mid-1] != array[mid+1]-array[mid]){
            return mid;
        }

        int lhigh=mid;
        findMissingBinary(array,low,lhigh);


        return mid;
    }
}
