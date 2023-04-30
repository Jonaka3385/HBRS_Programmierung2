package speicherKlassen;

import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

public interface Puffer<T> {
    boolean isEmpty();
    int size();
    int capacity();
    void insert(T pElement) throws IllegalStateException;
    T remove() throws NoSuchElementException;
}
