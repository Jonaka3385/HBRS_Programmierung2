package speicherKlassen;

public interface Folge<T> extends Puffer<T> {
    T get(int pos);
    void set(int pos, T e);
    T remove(int pos);
    void insert(int pos, T e);
}
