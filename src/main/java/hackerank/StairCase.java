import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StairCase{

    static void staircase(int n) {
        // Complete this function
        int numOfSpace=n-1, numOfHash=1;
        for(int i=0; i < n; i++){
            printSpace(numOfSpace);
            printHash(numOfHash);
            System.out.println();
            numOfSpace--;
            numOfHash++;
        }
    }

    static void printSpace(int n){
        for(int i=0; i < n; i++){
            System.out.print(" ");
        }    
        
    }
    
    static void printHash(int n){
        for(int i=0; i < n; i++){
            System.out.print("#");
        }    
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }
}

