package speicher;

public class IntSuchbaum {
    IntBaumElement startWurzel;

    public IntSuchbaum() {
        startWurzel = null;
    }

    public boolean isEmpty() {
        return startWurzel == null;
    }

    public void insert(Integer integer) {
        if (isEmpty()) startWurzel = new IntBaumElement(integer);
        if (contains(integer)) return;
        IntBaumElement tmp = startWurzel;
        int status;
        while (true) {
            status = tmp.compare(integer);
            if (status < 0) {
                if (tmp.hasRechts()) tmp = tmp.rechts;
                else {
                    tmp.rechts = new IntBaumElement(integer);
                    break;
                }
            }
            else {
                if (tmp.hasLinks()) tmp = tmp.links;
                else {
                    tmp.links = new IntBaumElement(integer);
                    break;
                }
            }
        }
    }

    public boolean contains(Integer integer) {
        if (isEmpty()) return false;
        IntBaumElement tmp = startWurzel;
        int status;
        while (true) {
            status = tmp.compare(integer);
            if (status == 0) return true;
            if (status < 0) {
                if (tmp.hasRechts()) tmp = tmp.rechts;
                else break;
            }
            else {
                if (tmp.hasLinks()) tmp = tmp.links;
                else break;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return startWurzel.toString();
    }

    public int hoehe() {
        return hoehe(startWurzel, 0);
    }

    public int hoehe(IntBaumElement element, int counter) {
        if (element != null)
        {
            if (element.hasLinks() || element.hasRechts()) {
                counter++;
                int counter1 = hoehe(element.links, counter);
                int counter2 = hoehe(element.rechts, counter);
                counter = Math.max(counter1, counter2);
            }
        }
        return counter;
    }

    public int size() {
        return size(startWurzel, 0);
    }

    public int size(IntBaumElement element, int counter) {
        if (element != null)
        {
            if (element.hasLinks()) {
                counter++;
                counter = size(element.links, counter);
            }
            if (element.hasRechts()) {
                counter++;
                counter = size(element.rechts, counter);
            }
        }
        return counter;
    }

    public FolgeMitDynArray<Integer> preorder() {
        return null;
    }

    public FolgeMitDynArray<Integer> inorder() {
        return null;
    }

    public FolgeMitDynArray<Integer> postorder() {
        return null;
    }

    public FolgeMitDynArray<Integer> breitensuche() {
        return null;
    }
}
