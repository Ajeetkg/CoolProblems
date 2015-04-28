package hackerank;

import java.util.Scanner;

/**
 * Created by Ajeet on 3/28/2015.
 */
public class HalloweenParty {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int _testCases = in.nextInt();
        long _input;
        int count=0;
        long[] inputArray = new long[_testCases];
        while(_testCases > 0){
            _input = in.nextInt();
            inputArray[count] = _input;
            _testCases--;
            count++;
        }
        long[] values = getPieces(inputArray);
        for(long i:values ){
            System.out.println(i);
        }
    }

    private static long[] getPieces(long[] inputArray){
        long[] values = new long[inputArray.length];
        long  value;
        int count=0;
        for(long i:inputArray){
            if(i % 2 ==0){
                value= i/2 *i/2;
            }else{
                value=i/2*(i+1)/2;
            }
            values[count]=value;
            count++;
        }
        return values;
    }
}
