package speicher;

import main_classes.Funktion;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StapelMitArray<T> implements Stapel<T>{
    private final T[] array;
    private final int max;
    private int size;

    public StapelMitArray(int maxGroesse){
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
    public void insert(T e) throws IllegalStateException {
        if (size == max){
            throw new IllegalStateException();
        }
        array[size] = e;
        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        size--;
        T tmp = array[size];
        array[size] = null;
        return tmp;

    }

    @Override
    public T top() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        return array[size-1];
    }

    public void applyToAll(Funktion pFunktion){
        if (isEmpty()) return;
        Integer[] intA = new Integer[capacity()];
        if (!(array[0] instanceof Integer)) throw new IllegalStateException("No Integer");
        try {
            for (int i = 0; i<size; i++) {
                intA[i] = (Integer) array[i];
            }
        } catch (Exception e) {
            throw new IllegalStateException("Array copying failed");
        }
        for (int i = 0; i < size; i++) {
            intA[i] = pFunktion.auswerten(intA[i]);
            array[i] = (T) intA[i];
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int current = -1;

            @Override
            public boolean hasNext() {
                return array[current+1] != null;
            }

            @Override
            public T next() {
                current++;
                return array[current];
            }
        };
    }
}
