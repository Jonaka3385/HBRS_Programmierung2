package speicherKlassen;

import java.util.NoSuchElementException;

public class DynArray<T> {
    private T[] array;
    private int size = 0;
    private int capacity = 1;

    public DynArray() {
        array = (T[]) new Object[capacity];
    }

    public DynArray(T element) {
        array = (T[]) new Object[capacity];
        array[0] = element;
        size++;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public T get(int pos) throws NoSuchElementException, IllegalStateException {
        if (pos < 0) throw new NoSuchElementException();
        if (pos >= size) throw new IllegalStateException();
        return array[pos];
    }

    public void set(int pos, T element) throws NoSuchElementException, IllegalStateException {
        if (pos < 0) throw new NoSuchElementException();
        if (pos >= size) throw new IllegalStateException();
        array[pos] = element;
    }

    public void addFirst (T element) {
        checkUpsizing();
        T[] tmp = (T[]) new Object[capacity];
        tmp[0] = element;
        for (int i = 0; i < size; i++) tmp[i+1] = array[i];
        array = tmp;
        size++;
    }

    public void addLast (T element) {
        checkUpsizing();
        array[size] = element;
        size++;
    }

    public T removeFirst() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException("array is empty");
        T[] tmp = (T[]) new Object[capacity];
        T te = array[0];
        size--;
        for (int i = 0; i < size; i++){
            tmp[i] = array[i+1];
        }
        array = tmp;
        checkDownsizing();
        return te;
    }

    public T removeLast() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException("array is empty");
        size--;
        T te = array[size];
        array[size] = null;
        checkDownsizing();
        return te;
    }

    private void checkUpsizing() {
        if (size == capacity) {
            capacity *= 2;
            T[] tmp = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) tmp[i] = array[i];
            array = tmp;
        }
    }

    private void checkDownsizing() {
        if (size == (capacity/4)) {
            capacity /= 2;
            T[] tmp = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) tmp[i] = array[i];
            array = tmp;
        }
    }
}
