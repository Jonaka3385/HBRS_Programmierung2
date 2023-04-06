package speicherKlassen;

import java.util.NoSuchElementException;

public interface Schlange extends Puffer {
    int front() throws NoSuchElementException;
}
