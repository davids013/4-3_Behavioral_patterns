package EndlessIteration_1;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    private int min;
    private int max;

    public Randoms(int min, int max) {
        random = new Random();
        this.min = min;
        this.max = ++max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator(this);
    }

    protected int getRandomInt() {
        return random.nextInt(min, max);
    }
}