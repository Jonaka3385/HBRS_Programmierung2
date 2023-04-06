package speicherKlassen;

import mainClasses.Funktion;
import java.util.NoSuchElementException;

public class StapelMitArray implements Stapel{
    private final int[] array;
    private final int max;
    private int size;

    public StapelMitArray(int maxGroesse){
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
        size--;
        return array[size];

    }

    @Override
    public int top() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException();
        }
        return array[size-1];
    }

    public void applyToAll(Funktion pFunktion){
        for (int i = 0; i < size; i++){
            array[i] = pFunktion.auswerten(array[i]);
        }
    }
}
