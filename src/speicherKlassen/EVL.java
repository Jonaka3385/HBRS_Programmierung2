package speicherKlassen;

import java.util.NoSuchElementException;

public class EVL<T> {
    private EVLElement<T> first;
    private EVLElement<T> last;
    private int size = 0;

    public EVL() {
        first = null;
        last = null;
    }

    public EVL(T content) {
        first = new EVLElement<>(content);
        last = first;
        size++;
    }

    public T getFirst() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();
        return first.content;
    }

    public T getLast() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();
        return last.content;
    }

    public void addLast(T e) {
        if (size == 0) {
            first = new EVLElement<>(e);
            last = first;
            size++;
            return;
        }
        EVLElement<T> tmp = last;
        last = new EVLElement<>(e);
        tmp.next = last;
        size++;
    }

    public T removeLast() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();
        size--;
        EVLElement<T> tmp = last;
        if (size == 0) {
            first = null;
            last = null;
            return tmp.content;
        }
        last = first;
        while (last.next != tmp) {
            last = last.next;
        }
        last.next = null;
        return tmp.content;
    }

    public boolean contains(T e) {
        if (size == 0) return false;
        else if (first.content == e) return true;
        else {
            EVLElement<T> tmp = first;
            while (tmp.hasNext()) {
                tmp = tmp.next;
                if (tmp.content == e) return true;
            }
            return false;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) return "";
        return getAllStrings(first);
    }

    private String getAllStrings(EVLElement<T> t) {
        StringBuilder str = new StringBuilder();
        str.append(t.toString());
        if (t.hasNext()) str.append("-").append(getAllStrings(t.next));
        return str.toString();
    }
}
