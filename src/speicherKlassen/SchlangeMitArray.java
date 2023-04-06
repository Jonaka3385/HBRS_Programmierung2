package speicherKlassen;

import java.util.NoSuchElementException;

public class SchlangeMitArray implements Schlange {
    private final int[] array;
    private final int max;
    private int size;

    public SchlangeMitArray(int maxGroesse){
        max = maxGroesse;
        array = new int[max];
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
    public void insert(int pElement) throws IllegalStateException {
        if (size == max){
            throw new IllegalStateException();
        }
        array[size] = pElement;
        size++;
    }

    @Override
    public int remove() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        int tmp = array [0];
        for (int i = 0; i < size; i++) {
            array[i] = array[i+1];
        }
        size--;
        return tmp;
    }

    @Override
    public int front() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        return array[0];
    }
}
