package designpattern;

/**
 * Created by Ajeet on 4/1/2015.
 */
public class ChainResponsibility {

    public static void main(String[] args) {
        ATMDispenser dispenser10 = new Dispense10(10);
        ATMDispenser dispenser20 = new Dispense20(20);
        ATMDispenser dispenser50 = new Dispense50(50);
        dispenser10.setNext(dispenser20);
        dispenser20.setNext(dispenser50);

        dispenser10.dispenseMoney("Dispense 15", 15);


    }
}


abstract class ATMDispenser {


    private ATMDispenser next;
    private int value;



    ATMDispenser(int value) {
        this.value = value;
    }

    public void setNext(ATMDispenser atmDispenser) {
        this.next = atmDispenser;
    }

    public void dispenseMoney(String message, int checked) {
        if (value > checked) {
            dispensed(message);
        }
        if (next != null) {
            next.dispenseMoney(message, checked);
        }
    }

    abstract void dispensed(String message);

}

class Dispense10 extends ATMDispenser {

    Dispense10(int dispensedMoney) {
        super(dispensedMoney);
    }

    public void dispensed(String message) {
        System.out.println("Dispense10  " + message);
    }

}

class Dispense20 extends ATMDispenser {
    Dispense20(int dispensedMoney) {
        super(dispensedMoney);
    }

    public void dispensed(String message) {
        System.out.println("Dispense20  " + message);
    }
}

class Dispense50 extends ATMDispenser {
    Dispense50(int dispensedMoney) {
        super(dispensedMoney);
    }

    public void dispensed(String message) {
        System.out.println("Dispensed50 " + message);
    }
}

