package hackerank;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * Created by Ajeet on 4/5/2015.
 */
public class StringCompressor {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String _str = in.nextLine();
        String value = compress(_str);
        System.out.println(value);


    }

    public static void main1(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }

        res = compress(_str);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

    static String compress(String str) {
        if(str.length() <=1){
            return str;
        }

        String compressedVal="";
        char[] chars = str.toCharArray();
        int count=0;
        int finalCharacter=0; //chars.length;
        for(int i=0; i<chars.length-1;i++){
            if(chars[i] == chars[i+1]){
                count++;
            }else{
                compressedVal = compressedVal+chars[i];
                if(count != 0){
                    compressedVal = compressedVal+(count+1);
                }
                count=0;
            }

            //Print the last character
            if(finalCharacter==chars.length-2){
                compressedVal = compressedVal+chars[i+1];
                if(count != 0){
                    compressedVal = compressedVal+(count+1);
                }
            }
            finalCharacter ++;
        }


        return compressedVal;
    }



}
