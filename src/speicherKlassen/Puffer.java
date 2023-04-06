package speicherKlassen;

import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

public interface Puffer {
    boolean isEmpty();
    int size();
    int capacity();
    void insert(int pElement) throws IllegalStateException;
    int remove() throws NoSuchElementException;
}
