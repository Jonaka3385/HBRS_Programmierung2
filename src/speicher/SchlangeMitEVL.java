package speicher;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SchlangeMitEVL<T> implements Schlange<T> {
    private final EVL<T> evl;
    private int size;

    public SchlangeMitEVL(){
        evl = new EVL<>();
        size = 0;
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
    public void insert(T e) throws IllegalStateException {
        if (e != null) evl.addLast(e);
        else throw new IllegalStateException();
        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        size--;
        return evl.removeFirst();
    }

    @Override
    public T front() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        return evl.getFirst();
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return evl.iterator();
    }
}
