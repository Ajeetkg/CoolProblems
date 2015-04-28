package datastructure;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ajeet on 3/31/2015.
 */
public class CheckEnum {

    public static void main(String[] args){
        System.out.println(UserType.values().length);
       // System.out.println("pp"+DAYS_TYPE.MONDAY.getName());
        System.out.println("**"+DAYS_TYPE.SUNDAY);
        getConstantMap(UserType.class);
    }

    public static <T extends Enum<T>> Map<String, String> getConstantMap(
            Class<T> klass) {

        Map<String, String> vals = new HashMap<>(0);

        try {
            Method m = klass.getMethod("values", null);

            Object obj = m.invoke(null, null);
            System.out.println(m+", "+klass.getMethod("values"));
            System.out.println(obj.getClass());

            for (Enum<T> enumval : (Enum<T>[]) obj) {
                vals.put(enumval.name(), enumval.toString());
                System.out.println(enumval.name());
            }

        } catch (Exception ex) {
            // shouldn't happen...
        }

        return vals;
    }
}

enum DAYS_TYPE{
    SUNDAY("REST"),
    MONDAY("WORK");
    private String name;

    private DAYS_TYPE(String name){
        System.out.println("---"+name);
        this.name=name;
    }


    public String getName(){
        System.out.println("++"+name);
        return name;
    }
}

class Employee{
    private String name;
    Employee(String name){
        this.name=name;
    }
}
enum UserType{
    RESELLER("Reseller"),

    SERVICE_MANAGER("Manager"),

    HOST("Host");

    private String name;

    private UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String name){
        System.out.println("----Come");
    }
}
