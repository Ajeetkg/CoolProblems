package hackerank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by Ajeet on 3/28/2015.
 */
public class PangramWords {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String _str = in.nextLine();
        String isPangram = isPangram(_str);
        System.out.println(isPangram);


    }

    private static String isPangram(String str){

        char[] cArray= str.toLowerCase().toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i=0; i < cArray.length;i++) {
            if (Character.isLetter(cArray[i])) {
                set.add(new Character(cArray[i]));
            }
        }

        if(set.size() == 26){
            return "pangram";
        }
        return "not pangram";
    }
}
