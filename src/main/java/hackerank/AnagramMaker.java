package hackerank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ajeet on 4/15/2015.
 *
 * Alice recently started learning about cryptography and found that anagrams are very useful. Two strings are anagrams of each other if they have same character set. For example strings "bacdc" and "dcbac" are anagrams, while strings "bacdc" and "dcbad" are not.

 Alice decides on an encryption scheme involving 2 large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. She need your help in finding out this number.

 Given two strings (they can be of same or different length) help her in finding out the minimum number of character deletions required to make two strings anagrams. Any characters can be deleted from any of the strings.

 Input Format
 Two lines each containing a string.

 Constraints
 1 <= Length of A,B <= 10000
 A and B will only consist of lowercase latin letter.

 Output Format
 A single integer which is the number of character deletions.

 Sample Input #00:

 cde
 abc
 Sample Output #00:

 4
 Explanation #00:
 We need to delete 4 characters to make both strings anagram i.e. 'd' and 'e' from first string and 'b' and 'a' from second string.
 */
public class AnagramMaker {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String str1= in.nextLine();
        String str2=in.nextLine();

        System.out.println(getCharacterDeletedCount(str1,str2));

    }

    private static long getCharacterDeletedCount(String str1, String str2){
        char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();
        Arrays.sort(str1Char);
        Arrays.sort(str2Char);

        return deletedCharacterFinder(str1Char,str2Char);




    }

    private static long deletedCharacterFinder(char[] chars1, char[] chars2){
        int pointer1=0, pointer2=0;
        char[] deletedChars = new char[chars1.length+chars2.length];
        int deletedCharsCount=0;
        int totalChars=chars1.length+chars2.length;
        int charCount=0;
        while(charCount < totalChars){
            if(pointer1 == chars1.length || pointer2 == chars2.length){
                break;
            }
            if((int)chars1[pointer1] == (int)chars2[pointer2]){
                charCount=charCount+2;
                pointer1++;
                pointer2++;
            }else if((int)chars1[pointer1] < (int)chars2[pointer2]){
                pointer1++;
                deletedCharsCount++;
                charCount++;
            }else{
                pointer2++;
                deletedCharsCount++;
                charCount++;
            }


        }
        if(pointer1 < chars1.length){
            deletedCharsCount= deletedCharsCount + (chars1.length-pointer1);
        }
        if(pointer2 < chars2.length){
            deletedCharsCount = deletedCharsCount+(chars2.length-pointer2);
        }
        return deletedCharsCount;
    }
}
