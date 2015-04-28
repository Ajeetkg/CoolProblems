package hackerank;

import java.util.Scanner;

/**
 * Created by Ajeet on 4/5/2015.
 */
public class MissingAPelementFinder {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int numTerms = in.nextInt();
        int[] apArray = new int[numTerms];
        int count=0;
        for(int i=0; i < numTerms; i++){
            int elements = in.nextInt();
            apArray[count] = elements;
            count++;
        }
        System.out.println(findElements(apArray));
    }

    private static int findElements(int[] apArray){
        int nextElement=apArray[0];
        int difference=(apArray[apArray.length-1]-apArray[0])/apArray.length;
        int count=0;
        for(int i=1; i<apArray.length;i++){
            nextElement = nextElement+difference;
            if(!(nextElement == apArray[i])){
                return nextElement;
            }
        }
        return nextElement;
    }
}
