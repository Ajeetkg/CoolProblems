package coreJava;

/**
 * Created by Ajeet on 4/2/2015.
 */
public class VMWareTest {


    public static void main(String[] args) {
        System.out.println(fun(2));
        int[] array= {8,2,4,5,6};
        System.out.println(getSecondLargest(array));
        // int[] array1= {-3,-12,-4,-8,-6}
        checkFunction();
    }

    private static int fun(int n) {
        if (n == 4)
            return 2;

        else {
            return 2 * fun(n + 1);
        }
    }

    private static int getSecondLargest(int[] array) {
        int max1 = 0, max2 = 0;

        if (array.length > 0) {
            max1 = array[0];
            max2 = array[0];
        }

        boolean isFirstAssignmentForMax2 = true;
        for (int i = 1; i < array.length; i++) {

            if (array[i] > max1) {
                max1 = array[i];
                max2 = max1;
            } else if ((array[i] < max1 && array[i] > max2)) {
                max2 = array[i];
            } else if (isFirstAssignmentForMax2) {
                max2 = array[i];
                isFirstAssignmentForMax2 = false;
            }
        }
        return max2;

    }

    private static void checkFunction(){
        int[] A ={1,9,3,12,5,6};
        int n = A.length;
        //Iterate through all the elements
        for ( int j = 0; j < n - 1; j++ ) {
            for (int k = 0; k < n - j - 1; k++) {
                if (A[k] < A[k + 1]) {
                    int temp=A[k];
                    A[k] = A[k+1];
                    A[k+1] = temp;
                }
            }

        }
        for(int i : A){
            System.out.print(i+", ");
        }
    }

    private static void Swap(int first, int second){
        System.out.println(first + ", "+ second);
        first = first+second;
        String s = "Ajeet";
        //s.compareTo()

        second = first -second;
        first = first -second;
    }
}
