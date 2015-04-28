package datastructure;

/*
    Class holds 10 integers which are the data elements stored in an array.   Implement the constructor, get & put methods.
    Put – stores data in the hashtable and returns false if the hashtable is full,  true otherwise
    Get – Takes an argument,  returns the data if found in the array,  else return UNKNOWN
    */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CustomHashTable {
    Entry[] myarray = new Entry[10];


    public static void main(String[] args) {
        CustomHashTable customHashTable = new CustomHashTable();
        customHashTable.put(23);
        customHashTable.put(46);
        customHashTable.put(1);
        customHashTable.put(13);

        print(customHashTable.myarray);

        int d = customHashTable.get(13);
        if (d == 13)
            System.out.println("Found");
        else
            System.out.println("Not Found");

        int d1 = customHashTable.get(14);
        if (d1 == 14)
            System.out.println("Found");
        else
            System.out.println("Not Found");

        try {
            InputStream inputStream = customHashTable.getClass().getResourceAsStream("life");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        }catch(Exception e){

        }

    }

    private static void print(Entry[] array) {
        int count=0;
        for(Entry entry:array){
            if(entry != null){
                count=0;
                while(entry != null){

                    System.out.println(count+ ", key: "+ entry.key);
                    entry = entry.next;
                    count++;
                }
            }
        }
    }

    synchronized boolean put(int data) {
        boolean isSuccess = false;
        Entry entry = new Entry(data);
        if (myarray[data % 10] == null) {
            myarray[data % 10] = entry;
            isSuccess = true;
        } else {
            Entry existingEntry = myarray[data % 10];
            while (existingEntry.next != null) {
                existingEntry = existingEntry.next;
            }
            existingEntry.next = entry;
            isSuccess = true;
        }
        return isSuccess;

    }

    int get(int data) {
        int location = data % 10;
        Entry entryVal = myarray[location];
        while (entryVal != null) {
            if (entryVal.key == data) {
                break;
            }
            entryVal = entryVal.next;
        }
        if(entryVal != null){
            return entryVal.key;
        }
        return 0;
    }

    static class Entry {
        private int key;
        private Entry next;

        Entry(int data) {
            this.key = data;
        }

        Entry(int key, Entry next) {
            this.key = key;
            this.next = next;
        }
    }
}

/*
Example usage -
        hashtable hash = new Hashtable()
        hash.put(23)
        hash.put(46)
        hash.put(1)
        hash.put(13)

        int d = hash.get(13)
        if( d == 13)
        println "Found"
        else
        println "Not found"

        d = hash.get(14)
        if ( d == 14)
        println "Found"
        else
        println "Not found"

        Output:
        Found
        Not Found
}
*/



