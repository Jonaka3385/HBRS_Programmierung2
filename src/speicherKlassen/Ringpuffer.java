package speicherKlassen;

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

    public int size(){
        return size;
    }

    public T get(int pos) throws NoSuchElementException {
        if (pos < 0 || pos >= size) throw new NoSuchElementException();
        return array[pos];
    }

    public void set(int pos, T element) {
        if (pos < 0 || pos >= size) throw new NoSuchElementException();
        array[pos] = element;
    }

    public void addFirst(T element) throws NoSuchElementException {
        if (size == capacity) {
            removeLast();
            addFirst(element);
        } else {
            T[] tmp = (T[]) new Object[capacity];
            tmp[0] = element;
            for (int i = 0; i < size; i++) {
                tmp[i + 1] = array[i];
            }
            array = tmp;
            size++;
        }
    }

    public void addLast(T element) throws NoSuchElementException {
        if (size == capacity) {
            removeFirst();
            addLast(element);
        } else {
            array[size] = element;
            size++;
        }
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