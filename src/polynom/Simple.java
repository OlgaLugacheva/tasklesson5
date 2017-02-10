package polynom;

/**
 * Created by Olga on 10.02.2017.
 */
public class Simple implements Runnable {
    private final int[] ints;
    private final Semaphor[] semaphors;

    public Simple(int[] ints, Semaphor[] semaphors) {
        this.ints = ints;
        this.semaphors = semaphors;
    }

    @Override
    public void run() {
        for (int i : ints) {
            int simple = i ;
            for (Semaphor cons: semaphors) {
                cons.take(0, 0, simple);
            }
        }
    }
}
