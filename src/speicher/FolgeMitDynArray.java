package speicher;

import org.jetbrains.annotations.NotNull;

import java.util.NoSuchElementException;

public class FolgeMitDynArray<T> implements Folge<T> {
    private DynArray<T> dynArray;

    public FolgeMitDynArray(){
        dynArray = new DynArray<>();
    }

    @Override
    public boolean isEmpty() {
        return dynArray.size() == 0;
    }

    @Override
    public int size() {
        return dynArray.size();
    }

    @Override
    public int capacity() {
        return dynArray.capacity();
    }

    @Override
    public T get(int pos) {
        return dynArray.get(pos);
    }

    @Override
    public void set(int pos, T e) {
        dynArray.set(pos, e);
    }

    @Override
    public void insert(T e) {
        dynArray.addLast(e);
    }

    @Override
    public void insert(int pos, T e) throws IllegalStateException {
        if (pos < 0) throw new NoSuchElementException();
        if (pos >= dynArray.capacity()) throw new IllegalStateException();
        DynArray<T> tmp = new DynArray<>();
        for (int i = 0; i < pos; i++) {
            tmp.addLast(dynArray.get(i));
        }
        tmp.addLast(e);
        for (int i = pos+1; i < dynArray.size(); i++) {
            tmp.addLast(dynArray.get(i));
        }
        dynArray = tmp;
    }

    @Override
    public T remove() throws NoSuchElementException {
        return dynArray.removeFirst();
    }

    @Override
    public T remove(int pos) throws NoSuchElementException, IllegalStateException {
        T element = dynArray.get(pos);
        DynArray<T> tmp = new DynArray<>();
        for (int i = 0; i < pos; i++) {
            tmp.addLast(dynArray.get(i));
        }
        for (int i = pos+1; i < dynArray.size(); i++) {
            tmp.addLast(dynArray.get(i));
        }
        dynArray = tmp;
        return element;
    }

    public void append(@NotNull Folge<T> folge) {
        for (int i = 0; i < folge.size(); i++) this.insert(folge.get(i));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof FolgeMitDynArray<?> folge2) {
            if (this.size() == folge2.size()) {
                for (int i = 0; i < size(); i++) {
                    if(!this.get(i).equals(folge2.get(i))) return false;
                }
                return true;
            }
        }
        return false;
    }
}
