package coreJava;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * Find the common elements in two arrays. O(n)
 */
public class ListFinder{

    public static void main(String[] args){

        String[] listA={"Fremont", "Dublin", "San Jose", "SFO"};
        String[] listB = {"Livermore", "Fremont", "Dublin"};

        String[] common=findCommonEfficient(listA,listB);
        System.out.println(common[0]+","+common[1]);






    }

    private static String[] findCommonEfficient(String[] listA, String[] listB){
        Map<String, AtomicInteger> mapA = new HashMap<>();
        String[] listArray = new String[listA.length+listB.length];
        int count=0;
        for(String val: listA){
            if(mapA.get(val) == null){
                mapA.put(val,new AtomicInteger(1));
            }else{
                AtomicInteger atomicInteger = mapA.get(val);
                atomicInteger.getAndIncrement();
                mapA.put(val,atomicInteger );
            }
        }
        for(String val: listB){
            if(mapA.get(val) != null){
                listArray[count]=val;
                count++;
            }
        }
        return listArray;
    }
    private static String[] findCommon(String[] listA, String[] listB){

        //Sort list A
        Arrays.sort(listA);
        int length = listA.length > listB.length? listA.length: listB.length;
        int count=0;
        String[] commonElements= new String[length];
        for(int i=0; i < listA.length; i++){
            for(int j=i; j<listB.length;j++) {
                if (listA[i].equalsIgnoreCase(listB[j])) {
                    commonElements[count] = listA[i];
                    count++;
                }
            }

        }
        return commonElements;



    }


}