package hackerank;

import java.util.Scanner;

/**
 * Created by Ajeet on 3/27/2015.
 */
public class MaximumXOR {

    static int maxXor(int left, int right) {
        int temp=0, max=0;

        for(int i=left; i<=right;i++){
           for(int j=i;j<=right;j++){
               temp = i^j;
               if(temp > max){
                   max=temp;
               }
           }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = in.nextInt();

        int _r;
        _r = in.nextInt();

        res = maxXor(_l, _r);
        System.out.println(res);

    }
}
