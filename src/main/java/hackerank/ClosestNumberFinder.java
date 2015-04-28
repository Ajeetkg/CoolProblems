package hackerank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ajeet on 3/28/2015.
 *
 * Problem Statement

 Sorting is often useful as the first step in many different tasks. The most common task is to make finding things easier, but there are other uses, as well.

 Challenge
 Given a list of unsorted integers, A={a1,a2,…,aN}, can you find the pair of elements that have the smallest absolute difference between them? If there are multiple pairs, find them all.

 Input Format
 The first line of input contains a single integer, N, representing the length of array A.
 In the second line, there are N space-separated integers, a1,a2,…,aN, representing the elements of array A.

 Output Format
 Output the pairs of elements with the smallest difference. If there are multiple pairs, output all of them in ascending order, all on the same line (consecutively) with just a single space between each pair of numbers. If there's a number which lies in two pair, print it two times (see the sample case #3 for explanation).

 Constraints

 2≤N≤200000
 −107≤ai≤107
 ai≠aj,where 1≤i<j≤N
 Sample Input #1

 10
 -20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854
 Sample Output #1

 -20 30
 Explanation
 (30) - (-20) = 50, which is the smallest difference.

 Sample Input #2

 12
 -20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470
 Sample Output #2

 -520 -470 -20 30
 Explanation
 (-470) - (-520) = 30 - (-20) = 50, which is the smallest difference.

 Sample Input #3

 4
 5 4 3 2
 Sample Output #3

 2 3 3 4 4 5
 Explanation
 Here, the minimum difference will be 1. So valid pairs are (2, 3), (3, 4), and (4, 5). So we have to print 2 once, 3 and 4 twice each, and 5 once.

 */
public class ClosestNumberFinder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int _a = in.nextInt();
        long[] array = new long[_a];
        int indx=0;
        while(_a > 0){
            array[indx] = in.nextInt();
            indx++;
            _a --;
        }

        List<long[]> list = findPair(array);
        for(long[] element: list){
            System.out.print(element[0]+" "+element[1]+" ");
        }
    }

    private static List<long[]> findPair(long[] array){
        List<long[]> list = new ArrayList<>();
        Arrays.sort(array);
        long[] pair = new long[2];
        long difference,min=array[1]-array[0];
        for(int i=0; i<array.length-1;i++){
            pair[0]=array[i];
            pair[1]=array[i+1];
            difference = array[i+1]-array[i];
            if(difference < min){
                min = difference;
                list.clear();
                list.add(pair);
                pair = new long[2];
            }else if(difference == min){
                list.add(pair);
                pair = new long[2];
            }
        }
        return list;
    }
}
