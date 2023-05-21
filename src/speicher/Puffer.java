package speicher;

import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

public interface Puffer<T> extends Iterable<T> {
    boolean isEmpty();
    int size();
    int capacity();
    void insert(T e) throws IllegalStateException;
    T remove() throws NoSuchElementException;
}
