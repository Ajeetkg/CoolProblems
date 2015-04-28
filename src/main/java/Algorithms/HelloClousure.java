package Algorithms;


import java.util.HashMap;
import java.util.Map;

public class HelloClousure {

    interface C {
        String c();
    }

    public static void main(final String[] args) {

        //final C c = () -> "Hello World";

        D c = new D();

        Map map = new HashMap<>();

        //System.out.println(c.c());



    }

    static class D implements C{
        public String c(){
            System.out.println("HI");
            return "London";
        }
    }
}

