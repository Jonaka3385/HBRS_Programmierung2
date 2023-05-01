package speicher;

import java.util.NoSuchElementException;

public class FolgeMitRing<T> implements Folge<T> {
    private Ringpuffer<T> ringpuffer;

    public FolgeMitRing(int capacity){
        ringpuffer = new Ringpuffer<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return ringpuffer.size() == 0;
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
    public T get(int pos) {
        return ringpuffer.get(pos);
    }

    @Override
    public void set(int pos, T e) {
        ringpuffer.set(pos, e);
    }

    @Override
    public void insert(T e) throws IllegalStateException {
        ringpuffer.addLast(e);
    }

    @Override
    public void insert(int pos, T e) throws NoSuchElementException, IllegalStateException {
        if (pos < 0) throw new NoSuchElementException();
        if (pos >= ringpuffer.capacity()) throw new IllegalStateException();
        Ringpuffer<T> tmp = new Ringpuffer<>(ringpuffer.capacity());
        for (int i = 0; i < pos; i++) {
            tmp.addLast(ringpuffer.get(i));
        }
        tmp.addLast(e);
        for (int i = pos+1; i < ringpuffer.size(); i++) {
            tmp.addLast(ringpuffer.get(i));
        }
        ringpuffer = tmp;
    }

    @Override
    public T remove() throws NoSuchElementException {
        return ringpuffer.removeFirst();
    }

    @Override
    public T remove(int pos) throws NoSuchElementException, IllegalStateException {
        T element = ringpuffer.get(pos);
        Ringpuffer<T> tmp = new Ringpuffer<>(ringpuffer.capacity());
        for (int i = 0; i < pos; i++) {
            tmp.addLast(ringpuffer.get(i));
        }
        for (int i = pos+1; i < ringpuffer.size(); i++) {
            tmp.addLast(ringpuffer.get(i));
        }
        ringpuffer = tmp;
        return element;
    }
}
