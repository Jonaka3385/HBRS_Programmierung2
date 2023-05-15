package speicher;

import org.jetbrains.annotations.NotNull;

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

    public T removeFirst() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();
        size--;
        EVLElement<T> tmp = first;
        if (size == 0) {
            first = null;
            last = null;
            return tmp.content;
        }
        first = first.next;
        tmp.next = null;
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

    private @NotNull String getAllStrings(@NotNull EVLElement<T> t) {
        StringBuilder str = new StringBuilder();
        str.append(t.toString());
        if (t.hasNext()) str.append("-").append(getAllStrings(t.next));
        return str.toString();
    }

    public void zip(@NotNull EVL<T> other){
        EVL<T> tmp = new EVL<>();
        if (this.size > other.size()){
            int i;
            int ts = this.size;
            int os = other.size();
            for (i = 0; i < os; i++) {
                tmp.addLast(this.removeFirst());
                tmp.addLast(other.removeFirst());
            }
            for (i = os; i < ts; i++) {
                tmp.addLast(this.removeFirst());
            }
        }   else {
            int i;
            int ts = this.size;
            int os = other.size();
            for (i = 0; i < ts; i++) {
                tmp.addLast(this.removeFirst());
                tmp.addLast(other.removeFirst());
            }
            for (i = ts; i < os; i++) {
                tmp.addLast(other.removeFirst());
            }
        }
        int tmpS = tmp.size();
        for (int i = 0; i < tmpS; i++) {
            this.addLast(tmp.removeFirst());
        }
    }
}
