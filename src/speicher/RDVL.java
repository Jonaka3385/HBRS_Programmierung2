package speicher;

import java.util.NoSuchElementException;

public class RDVL<T> {
    private RDVLElement<T> entry;
    private int size = 0;

    public RDVL() {
        entry = null;
    }

    public RDVL(T content) {
        entry = new RDVLElement<>(content);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void add(T e) {
        if (size == 0) {
            entry = new RDVLElement<>(e);
        } else if (size == 1) {
            RDVLElement<T> tmp = new RDVLElement<>(e);
            entry.next = tmp;
            entry.prev = tmp;
            tmp.next = entry;
            tmp.prev = entry;
        } else {
            RDVLElement<T> tmpEp = entry.prev;
            RDVLElement<T> tmpN = new RDVLElement<>(e);
            tmpEp.next = tmpN;
            entry.prev = tmpN;
            tmpN.prev = tmpEp;
            tmpN.next = entry;
        }
        size++;
    }

    public T remove() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();
        T tmpC = entry.content;
        RDVLElement<T> tmpE = entry.prev;
        entry = entry.next;
        tmpE.next = entry;
        entry.prev = tmpE;
        size--;
        return tmpC;
    }

    public T element() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();
        return entry.content;
    }

    public void next(int s) throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();
        if (size == 1) s = 0;
        for (int i = 0; i < s; i++) {
            entry = entry.next;
        }
    }

    public void prev(int s) throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();
        if (size == 1) s = 0;
        for (int i = 0; i < s; i++) {
            entry = entry.prev;
        }
    }
}
