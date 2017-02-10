package polynom;

/**
 * Created by Olga on 10.02.2017.
 */
public class Semaphor {

    boolean locCube = false;
    boolean locQuad = false;
    boolean locSimple = false;
    private Integer sum = 0;

    public synchronized void take(int cub, int quad, int simple) {

        if (cub != 0) {
            Take(locCube);
            sum += cub;
        }
        if (quad != 0) {
            Take(locQuad);
            sum += quad;
        }
        if (simple != 0) {
            Take(locSimple);
            sum += simple;
        }

        this.notify();
    }

    private void Take(boolean lock) {
        while (!lock) {
            Thread.yield();
        }
    }

    public int getSum() {
        return sum;
    }


}
