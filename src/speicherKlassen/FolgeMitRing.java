package speicherKlassen;

import java.util.NoSuchElementException;

public class FolgeMitRing<T> implements Folge<T> {
    private final Ringpuffer<T> ring;
    private final int capacity;

    public FolgeMitRing(int capacity){
        ring = new Ringpuffer<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public boolean isEmpty() {
        return ring.size() == 0;
    }

    @Override
    public int size() {
        return ring.size();
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void insert(T e) throws IllegalStateException {
        ring.addLast(e);
    }

    @Override
    public void insert(int pos, T e) throws IllegalStateException {
        if (ring.size() == capacity) throw new IllegalStateException();
        Ringpuffer<T> tmp = new Ringpuffer<>(capacity);
        T element = ring.get(pos);
        for (int i = 0; i < pos; i++) {
            tmp.addLast(ring.get(i));
        }
        tmp.addLast(e);
        for (int i = pos+1; i < ring.size(); i++) {
            tmp.addLast(ring.get(i));
        }
    }

    @Override
    public T remove() throws NoSuchElementException {
        return ring.removeFirst();
    }

    @Override
    public T remove(int pos) throws NoSuchElementException {
        T element = ring.get(pos);
        Ringpuffer<T> tmp = new Ringpuffer<>(capacity);
        for (int i = 0; i < pos; i++) {
            tmp.addLast(ring.get(i));
        }
        for (int i = pos+1; i < ring.size(); i++) {
            tmp.addLast(ring.get(i));
        }
        return element;
    }

    @Override
    public T get(int pos) {
        return ring.get(pos);
    }

    @Override
    public void set(int pos, T e) {
        ring.set(pos, e);
    }
}
