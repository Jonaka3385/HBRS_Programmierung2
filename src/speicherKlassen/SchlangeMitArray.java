package speicherKlassen;

import java.util.NoSuchElementException;

public class SchlangeMitArray<T> implements Schlange<T> {
    private final T[] array;
    private final int max;
    private int size;

    public SchlangeMitArray(int maxGroesse){
        max = maxGroesse;
        array = (T[]) new Object[max];
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
        return max;
    }

    @Override
    public void insert(T pElement) throws IllegalStateException {
        if (size == max){
            throw new IllegalStateException();
        }
        array[size] = pElement;
        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        T tmp = array [0];
        for (int i = 0; i < size-1; i++) {
            array[i] = array[i+1];
            array[i+1] = null;
        }
        size--;
        return tmp;
    }

    @Override
    public T front() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        return array[0];
    }
}
