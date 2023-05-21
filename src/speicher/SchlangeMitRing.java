package speicher;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
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

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int current = -1;

            @Override
            public boolean hasNext() {
                boolean b = false;
                try {
                    ringpuffer.get(current+1);
                    b = true;
                } catch (Exception ignored) {

                }
                return b;
            }

            @Override
            public T next() {
                current++;
                return ringpuffer.get(current);
            }
        };
    }
}
