package iterator_classes;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterator1DArray<T> implements Iterator<T> {
    private final T[] array;
    private int currentIndex;
    private final int endIndex;

    @Contract(pure = true)
    public Iterator1DArray(T @NotNull [] array) {
        this.array = array;
        this.currentIndex = 0;
        this.endIndex = array.length;
    }

    @Contract(pure = true)
    public Iterator1DArray(T @NotNull [] array, int start) {
        this.array = array;
        this.currentIndex = start;
        this.endIndex = array.length;
    }

    @Contract(pure = true)
    public Iterator1DArray(T @NotNull [] array, int start, int end) {
        this.array = array;
        this.currentIndex = start;
        this.endIndex = end;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < endIndex;
    }

    @Override
    public T next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T element = array[currentIndex];
        currentIndex++;
        return element;
    }
}
