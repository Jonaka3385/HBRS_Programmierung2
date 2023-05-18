package speicher;

import org.jetbrains.annotations.NotNull;

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

    public void append(@NotNull Folge<T> folge) throws IllegalStateException {
        if ((this.size() + folge.size()) > this.capacity()) throw new IllegalStateException();
        for (int i = 0; i < folge.size(); i++) this.insert(folge.get(i));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof FolgeMitRing<?> folge2) {
            if (this.size() == folge2.size()) {
                for (int i = 0; i < size(); i++) {
                    if(!this.get(i).equals(folge2.get(i))) return false;
                }
                return true;
            }
        }
        return false;
    }
}
