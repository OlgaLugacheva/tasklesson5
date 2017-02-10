package polynom;

/**
 * Created by Olga on 10.02.2017.
 */
public class Square implements Runnable {
    private final int[] ints;
    private final Semaphor[] semaphors;

    public Square(int[] ints, Semaphor[] semaphors) {
        this.ints = ints;
        this.semaphors = semaphors;
    }

    @Override
    public void run() {
        for (int i : ints) {
            int quad = i * i;
            for (Semaphor cons: semaphors) {
                cons.take(0, quad, 0);
            }
        }
    }
}