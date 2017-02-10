package polynom;

/**
 * Created by Olga on 10.02.2017.
 */
public class Cube implements Runnable {
    private final int[] ints;
    private final Semaphor[] semaphors;

    public Cube(int[] ints, Semaphor[] semaphors) {
        this.ints = ints;
        this.semaphors = semaphors;
    }

    @Override
    public void run() {
        for (int i : ints) {
            int cub = i * i * i;
            for (Semaphor cons: semaphors) {
                cons.take(cub, 0, 0);
            }
        }
    }
}
