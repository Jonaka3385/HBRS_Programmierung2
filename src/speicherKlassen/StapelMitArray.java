package speicherKlassen;

import mainClasses.Funktion;
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
        if ((array instanceof Integer[] int_array)) {
            for (int i = 0; i < size; i++) {
                int_array[i] = pFunktion.auswerten(int_array[i]);
                array[i] = (T) int_array[i];
            }
        } else {
            System.out.println("only Integer method. No effect on other datatype.");
        }
    }
}
