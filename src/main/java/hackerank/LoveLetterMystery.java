package hackerank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ajeet on 3/27/2015.
 */
public class LoveLetterMystery {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int _numberOfWords = Integer.parseInt(in.nextLine());
        List<String> words = new ArrayList<String>();

        while(_numberOfWords > 0){
            words.add(in.nextLine());
            _numberOfWords--;
        }
        int[] stepsArray = getPalindromes(words);
        for(int i: stepsArray){
            System.out.println(i);
        }
    }

    private static int[] getPalindromes(List<String> words){

        int[] stepsArray = new int[words.size()];
        int i=0;
        for(String word:words){
            stepsArray[i]=findSteps(word);
            i++;
        }
        return stepsArray;

    }

    private static int findSteps(String word){
        char[] chararry = word.toLowerCase().toCharArray();
        int len = chararry.length;
        int ascii_right, ascii_left, steps=0;
        for(int i=0; i<len/2;i++){
            ascii_left = (int)chararry[i];
            ascii_right = (int)chararry[len-(i+1)];
            steps = steps + Math.abs(ascii_right - ascii_left);
        }
        return steps;
    }
}
