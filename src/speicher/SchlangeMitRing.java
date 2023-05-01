package speicher;

import java.util.NoSuchElementException;

public class SchlangeMitRing<T> implements Schlange<T> {
    private final Ringpuffer<T> ringpuffer;

    public SchlangeMitRing(int capacity) {
        ringpuffer = new Ringpuffer<>(capacity);
    }

    @Override
    public int size() {
        return ringpuffer.size();
    }

    @Override
    public int capacity() {
        return ringpuffer.capacity();
    }

    @Override
    public boolean isEmpty() {
        return ringpuffer.size() == 0;
    }

    @Override
    public T front() throws NoSuchElementException {
        return ringpuffer.get(0);
    }

    @Override
    public void insert(T e) throws IllegalStateException {
        ringpuffer.addLast(e);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return ringpuffer.removeFirst();
    }
}
