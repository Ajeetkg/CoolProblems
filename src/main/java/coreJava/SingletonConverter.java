package coreJava;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ajeet on 4/2/2015.
 */
public class SingletonConverter {
    private static SingletonConverter instance;
    private SingletonConverter(){};
    private static SingletonConverter getInstance(){
        if(null == instance){
            instance = new SingletonConverter();
        }

        return instance;
    }

    public static void main(String[] args){
        SingletonConverter singletonConverter = SingletonConverter.getInstance();
        System.out.println(singletonConverter.getFullForm("NY"));
        System.out.println(singletonConverter.getFullForm("CA"));
    }

    private String getFullForm(String str){
        Map<String, String> map = new HashMap<>();
        map.put("NY","New York");
        map.put("CA", "California");

        return map.get(str);

    }

}
