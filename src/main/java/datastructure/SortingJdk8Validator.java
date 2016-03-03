package datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by agupta2 on 3/3/16.
 */
public class SortingJdk8Validator {

    public static void main(String[] args) {

        SortingJdk8Validator sortingJdk8Validator = new SortingJdk8Validator();
        sortingJdk8Validator.sortTest1();

    }


    public void sortTest1() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", "Nam", 18),
                        new Person("Peter","Auro", 23),
                        new Person("Peter", "Dharte",12),
                        new Person("Peter", "Bahn",40),
                        new Person("Peter", "Bahn",4),
                        new Person("Peter", "Bahn",20),
                        new Person("Pamela","Charles", 23),
                        new Person("David","Cecala", 12));
        System.out.println(persons);
        Comparator<Person> nameComparator = (o1, o2) -> o1.getFirstname().compareTo(o2.getFirstname());
        nameComparator = nameComparator.thenComparing((o1,o2)-> o1.getLastname().compareTo(o2.getLastname()));
        nameComparator = nameComparator.thenComparing((o1,o2) -> o1.getAge().compareTo(o2.getAge()));



        persons.sort(nameComparator);
        System.out.println("****************");
        System.out.println(persons);

    }

    class Person {
        String firstname;
        String lastname;
        Integer age;

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        Person(String firstname,String lastname, Integer age) {
            this.firstname=firstname;
            this.lastname=lastname;
            this.age=age;
        }

        @Override
        public String toString() {
            return "{" +
                    "'" + firstname +
                    " " + lastname + '\'' +
                    ", " + age +
                    '}';
        }
    }


}
