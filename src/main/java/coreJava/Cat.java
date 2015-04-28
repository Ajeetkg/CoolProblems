package coreJava;

/**
 * Created by Ajeet on 3/30/2015.
 */
 class Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
    public static void foo() {
        System.out.println("Animal");
    }

    public  void bar(){

    }
}

public class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public  void bar(){

    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        //Animal.foo(); // prints Animal
        //Cat.foo(); // prints Cat

        Animal a = new Animal();
        Animal b = new Cat();
        Cat c = new Cat();
        Animal d = null;

        a.foo(); // should not be done. Prints Animal
        b.foo(); // should not be done. Prints Animal because the declared type of b is Animal
        c.foo(); // should not be done. Prints Cat because the declared type of c is Cat
        d.foo(); // should not be done. Prints Animal because the declared type of b is Animal
    }

    public static void foo() {  // hides Animal.foo()
        System.out.println("Cat");
    }
}