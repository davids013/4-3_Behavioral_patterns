package EndlessIteration_1;

import java.util.Iterator;
import java.util.Random;

public class MyIterator implements Iterator {
    private Randoms randoms;

    public MyIterator(Randoms randoms) {
        this.randoms = randoms;
    }

    @Override
    public boolean hasNext() {
        return randoms.random != null;
    }

    @Override
    public Object next() {
        return randoms.getRandomInt();
    }
}
