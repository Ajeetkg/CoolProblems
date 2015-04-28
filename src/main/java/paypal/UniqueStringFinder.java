package paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ajeet on 4/7/2015.
 */
public class UniqueStringFinder {

    public static void main(String[] args){
        String[] strArray1={"Ajeet","Rohini","Romir"};
        String[] strArray2={"Rinku","Hannu","Ajeet"};

        print(findDuplicates(strArray1, strArray2));
        System.out.println();
        System.out.println("Ajeet".compareTo("Rohini"));
        System.out.println("Ajeet".compareTo("Aaam"));
        System.out.println("Ajeet".compareTo("Akeet"));
        System.out.println("Ajeet".compareTo("Ajeet"));

        Arrays.sort(strArray1, new NameComparator());
        Arrays.sort(strArray2, new NameComparator());
        int length = strArray1.length > strArray2.length ? strArray1.length: strArray2.length;
        int pointer1=0, pointer2=0;
        for(int i=0; i < length; i++){

        }

    }

    private static void print(String[] strArray){
        for(String str: strArray){
            System.out.print(str+", ");
        }
    }


    private static String[] findDuplicates(String[] strArray1, String[] strArray2){
        String[] duplicates = new String[strArray1.length+strArray2.length];
        int count=0;
        boolean matchFound=false;
        for(String str1:strArray1){
            matchFound=false;
            for(String str2:strArray2){
                if(str1.equalsIgnoreCase(str2)){
                    matchFound=true;
                   break;
                }
            }
            if(matchFound){
                duplicates[count]=str1;
                count++;
            }
        }
        return duplicates;
    }

    static class NameComparator implements Comparator<String>{

        public int compare(String str1, String str2){

            return str1.compareTo(str2);
        }
    }
}
