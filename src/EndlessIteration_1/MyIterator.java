package EndlessIteration_1;

import java.util.Iterator;

public class MyIterator implements Iterator {
    private final Randoms randoms;

    public MyIterator(Randoms randoms) {
        this.randoms = randoms;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = randoms.random != null;
        System.out.println("\tСледующий элемент " + ((hasNext) ? "" : "не ") + "найден");
        return hasNext;
    }

    @Override
    public Object next() {
        int x = randoms.getRandomInt();
        System.out.println("\tЧисло " + ((x % 2 == 0) ? "" : "не") + "чётное");
        return x;
    }
}
