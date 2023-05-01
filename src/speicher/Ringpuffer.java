package speicher;

import java.util.NoSuchElementException;

public class Ringpuffer<T> {
    private T[] array;
    private final int capacity;
    private int size;

    public Ringpuffer(int capacity) {
        this.capacity = capacity;
        size = 0;
        array = (T[]) new Object[capacity];
    }

    public int capacity() {
        return capacity;
    }

    public int size(){
        return size;
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

    public void addFirst(T element) throws IllegalStateException {
        if (size == capacity) throw new IllegalStateException();
        T[] tmp = (T[]) new Object[capacity];
        tmp[0] = element;
        for (int i = 0; i < size; i++) {
            tmp[i + 1] = array[i];
        }
        array = tmp;
        size++;
    }

    public void addLast(T element) throws IllegalStateException {
        if (size == capacity) throw new IllegalStateException();
        array[size] = element;
        size++;
    }

    public T removeFirst() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();
        size--;
        T tmp = array[0];
        for (int i = 0; i < size; i++) {
            array[i] = array[i+1];
        }
        array[size] = null;
        return tmp;
    }

    public T removeLast() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();
        size--;
        T tmp = array[size];
        array[size] = null;
        return tmp;
    }

    public void reset() {
        array = (T[]) new Object[capacity];
        size = 0;
    }
}
