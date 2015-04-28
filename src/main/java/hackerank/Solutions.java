package hackerank;

import java.util.*;

class Solutions {

    static int solveMeSecond(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
        int t;
        int a,b;
        t = in.nextInt();
        for(int i=0;i<t;i++){
            a = in.nextInt();
            b= in.nextInt();
            int result = solveMeSecond(a,b);
            System.out.println(result);
        }
    }
}
