package speicherKlassen;

public class RDVLElement<T> {
    public T content;
    public RDVLElement<T> next;
    public RDVLElement<T> prev;

    public RDVLElement(T content) {
        this.content = content;
    }

    public boolean hasNeighbor() {
        return next != null && prev != null;
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
