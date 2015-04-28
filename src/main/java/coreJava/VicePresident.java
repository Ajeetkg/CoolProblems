package coreJava;

/**
 * Created by Ajeet on 3/23/2015.
 */
public class VicePresident extends Employee {

    public Employee Employee(){
        return null;
    }
    public VicePresident(){
        //super();
        System.out.println("VicePresident");
    }
    public double getSalary(){
       // super.getSalary();
        double count=0l;
        System.out.println("VP Salary");
        return count;
    }
    public long getSalary1(){
        return 1l;
    }

    public double getSalary1(int a){
        return 1l;
    }

    public static void main(String[] args){
        //VicePresident vp = new VicePresident();
        //vp.getSalary();

        Employee ee = new VicePresident();
        ee.getSalary();
        System.gc();


    }

    public static String getEmail(){
        return "";
    }
}
