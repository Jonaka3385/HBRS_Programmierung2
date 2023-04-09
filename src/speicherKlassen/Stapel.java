package speicherKlassen;

import java.util.NoSuchElementException;

public interface Stapel<T> extends Puffer<T> {
    T top() throws NoSuchElementException;
}
