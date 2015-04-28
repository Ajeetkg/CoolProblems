package paypal;

/**
 * Created by BST on 4/7/2015.
 */
public class ReverseString {

    public static void main(String[] args){
        String str = "Hello";
        System.out.println(reverseString(str));
        System.out.println(reverseChar(str));
    }

    private static  String  reverseString(String str){
        if(str==null || str.length() <=1) return str;
        return reverseString(str.substring(1))+str.charAt(0);
    }

    private static String reverseChar(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=str.length()-1;i >=0;i--){
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }


}
