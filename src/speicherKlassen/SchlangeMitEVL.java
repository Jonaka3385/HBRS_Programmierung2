package speicherKlassen;

import java.util.NoSuchElementException;

public class SchlangeMitEVL<T> implements Schlange<T> {
    private final EVL<T> evl;
    private int size;

    public SchlangeMitEVL(){
        evl = new EVL<>();
        size = 0;
    }

    public SchlangeMitEVL(T content){
        evl = new EVL<>(content);
        size = 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void insert(Object pElement) throws IllegalStateException {
        if (pElement != null) evl.addLast((T) pElement);
        else throw new IllegalStateException();
        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        size--;
        return evl.removeLast();
    }

    @Override
    public T front() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        return evl.getFirst();
    }
}
