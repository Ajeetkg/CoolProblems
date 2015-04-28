package multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


public class MaximumFinder extends RecursiveTask<Integer> {

    private static final int SEQUENTIAL_THRESHOLD = 5;

    private final int[] data;
    private final int start;
    private final int end;

    public MaximumFinder(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public MaximumFinder(int[] data) {
        this(data, 0, data.length);
    }

    public static void main(String[] args) {
        // create a random data set
        final int[] data = new int[100];
        final Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100);
        }

        for (int i : data) {
            System.out.print(i + ", ");
        }
        String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        // Old looping
        for (String player : players) {
            System.out.print(player + "; ");
        }

        // Using lambda expression and functional operations
        players.forEach((player1) -> System.out.print(player1 + "; "));

        // Using double colon operator in Java 8
        players.forEach(System.out::println);


        new Thread(() -> System.out.println("Hello world !")).start();

        // submit the task to the pool
        final ForkJoinPool pool = new ForkJoinPool(4);
        final MaximumFinder finder = new MaximumFinder(data);
        System.out.println(pool.invoke(finder));
    }

    @Override
    protected Integer compute() {
        final int length = end - start;
        if (length < SEQUENTIAL_THRESHOLD) {
            return computeDirectly();
        }
        final int split = length / 2;
        final MaximumFinder left = new MaximumFinder(data, start, start + split);
       // left.compute();
       // left.fork();
        final MaximumFinder right = new MaximumFinder(data, start + split, end);
        return Math.max(right.compute(), left.compute());
    }

    private Integer computeDirectly() {
        System.out.println(Thread.currentThread() + " computing: " + start
                + " to " + end);
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }
}
