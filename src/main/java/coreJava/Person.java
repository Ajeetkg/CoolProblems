package coreJava;

import java.time.LocalDate;

/**
 * Created by Ajeet on 3/21/2015.
 */

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    int age;
    String emailAddress;


    public int getAge() {
        return this.age;
    }


    public void printPerson() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name: ").append(name);
        stringBuilder.append(", age: ").append(age);
        stringBuilder.append(", gender: ").append(gender);
        stringBuilder.append(", emailAddress: ").append(emailAddress);
        stringBuilder.append(", birthday: ").append(birthday);

        System.out.println(stringBuilder.toString());
    }
}