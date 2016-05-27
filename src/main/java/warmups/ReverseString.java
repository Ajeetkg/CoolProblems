package warmups;

/**
 * Created by agupta2 on 5/26/16.
 */
public class ReverseString {

    public static void main(String[] args){
        String name="Hello";
        System.out.println(reverseString(name));
    }

    private static String reverseString(String name){
        if(name == null || name.length()<=1) return name;
        return reverseString(name.substring(1))+name.charAt(0);
    }
}
