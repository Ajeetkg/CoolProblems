package hackerank;

import java.util.Scanner;
import java.io.*;
/**
 * Created by Ajeet on 3/27/2015.
 */
public class UtopianTree {



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        int _a;
        _a = in.nextInt();
        int _b;

        int[] cycles = new int[_a];
        for (int i = 0; i < _a; i++) {
            _b = in.nextInt();
            cycles[i]=_b;
        }

        cycles = getGrowthAfterCycles(cycles);
        for(int j: cycles){
            System.out.println(j);
        }
    }

    private static int[] getGrowthAfterCycles(int[] cycles){
        int[] resultOfCycle= new int[cycles.length];
        int result, count=0;
        for(int cycle: cycles){
            result = getGrowth(cycle);
            resultOfCycle[count]=result;
            count++;
        }

        return resultOfCycle;
    }

    private static int getGrowth(int cycle){
        int growthValue=1;
        for(int i=1; i<=cycle;i++){
            if(i % 2 ==0){
                growthValue=growthValue+1;
            }else{
                growthValue= growthValue+growthValue;
            }
        }
        return growthValue;
    }

}
