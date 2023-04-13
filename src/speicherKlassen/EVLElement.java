package speicherKlassen;

public class EVLElement<T> {
    public T content;
    public EVLElement<T> next;

    public EVLElement(T content) {
        this.content = content;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
