package hackerank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ajeet on 3/28/2015.
 *
 *
 */
public class AnagramWords {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int _testCases= Integer.parseInt(in.nextLine());
        String _str;
        int count=0;
        String[] cases= new String[_testCases];
        while(_testCases >0){
            _str = in.nextLine();
            cases[count]=_str;
            _testCases--;
            count++;
        }

        long[] anagramResult= findAnagrams(cases);
        for(long i: anagramResult){
            System.out.println(i);
        }


    }

    private static long[] findAnagrams(String[] cases){
        char[] value1, value2;
        int change=0, count=0;
        long[] changeArray = new long[cases.length];
        long length=0;
        for(String value:cases){
            length = value.length();
            char[] valueChar = value.toCharArray();

            value1 = Arrays.copyOfRange(valueChar,0,valueChar.length/2);
            value2 = Arrays.copyOfRange(valueChar,valueChar.length/2,valueChar.length);

            System.out.println(value1);
            System.out.println(value2);

            if(value1.length != value2.length){
                change=-1;
            }else{
                change=isAnagram(value1,value2);
            }

            changeArray[count] = change;
            count++;
        }
       return changeArray;

    }

    private static int isAnagram(char[] val1, char[] val2){

        Arrays.sort(val1);
        Arrays.sort(val2);
        int totalChanges=0;
        System.out.println(val1);
        System.out.println(val2);
        for(int i=0; i<val1.length;i++){
            if(val1[i] != val2[i]){
                totalChanges++;
            }
        }
        return totalChanges;
    }
}
