package speicher;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynArray<T> implements Iterable<T> {
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
        if (size >= 0) System.arraycopy(array, 0, tmp, 1, size);
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
        if (size >= 0) System.arraycopy(array, 1, tmp, 0, size);
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
            if (size >= 0) System.arraycopy(array, 0, tmp, 0, size);
            array = tmp;
        }
    }

    private void checkDownsizing() {
        if (size == (capacity/4)) {
            capacity /= 2;
            T[] tmp = (T[]) new Object[capacity];
            if (size >= 0) System.arraycopy(array, 0, tmp, 0, size);
            array = tmp;
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new DynArrayIterator<>(array);
    }

    private static class DynArrayIterator<T> implements Iterator<T> {
        T[] array;
        int current;

        DynArrayIterator(T[] array) {
            this.array = array;
            current = -1;
        }

        @Override
        public boolean hasNext() {
            return array[current+1] != null;
        }

        @Override
        public T next() {
            current++;
            return array[current];
        }
    }
}
