package datastructure;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

enum Strategy { /* Make sure to score quickly on T20 games */
    T20 {
        @Override
        public void play() {
            System.out.printf("In %s, If it's in the V, make sure it goes to tree %n", name());
        }
    },
    /* Make a balance between attach and defence in One day */
    ONE_DAY {
        @Override
        public void play() {
            System.out.printf("In %s, Push it for Single %n", name());
        }
    },
    /* Test match is all about occupying the crease and grinding opposition */
    TEST {
        @Override
        public void play() {
            System.out.printf("In %s, Grind them hard %n", name());
        }
    };

    public void play() {
        System.out.printf("In Cricket, Play as per Merit of Ball %n");
    }
}

/**
 * Java program to demonstrate that Enum can be used to implement Strategy * Pattern in Java. * * @author Javin
 */
public class EnumStrategy {
    private static final Logger logger = LoggerFactory.getLogger(EnumStrategy.class);

    public static void main(String args[]) {
        Player ctx = new Player(Strategy.T20);
        ctx.play();
        ctx.setStrategy(Strategy.ONE_DAY);
        ctx.play();
        ctx.setStrategy(Strategy.TEST);
        ctx.play();
    }
} /* * Player class, which uses different Strategy implementation. */

class Player {
    private Strategy battingStrategy;

    public Player(Strategy battingStrategy) {
        this.battingStrategy = battingStrategy;
    }

    public void setStrategy(Strategy newStrategy) {
        this.battingStrategy = newStrategy;
    }

    public void play() {
        battingStrategy.play();
    }
} /* * An Enum to implement Strategy design pattern in Java. Different instances of * Enum represent different batting strategy, based upon type of game e.g. T20, * One day international or Test match. */

