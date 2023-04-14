package speicherKlassen;

import mainClasses.Funktion;

import java.util.IllegalFormatException;
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
    public void insert(Object pElement) throws IllegalStateException {
        if (size == max){
            throw new IllegalStateException();
        }
        array[size] = (T) pElement;
        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        size--;
        return array[size];

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
}
