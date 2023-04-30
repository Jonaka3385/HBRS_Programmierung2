package speicher;

import java.util.NoSuchElementException;

public interface Schlange<T> extends Puffer<T> {
    T front() throws NoSuchElementException;
}
