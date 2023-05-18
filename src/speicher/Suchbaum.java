package speicher;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;

public class Suchbaum<T extends Comparable<T>> {
    private BaumKnoten<T> startWurzel;
    private final Comparator<T> comparator;

    public Suchbaum() {
        startWurzel = null;
        comparator = null;
    }

    public Suchbaum(Comparator<T> comparator) {
        startWurzel = null;
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return startWurzel == null;
    }

    public void insert(T element) {
        if (isEmpty()) startWurzel = new BaumKnoten<>(element);
        if (contains(element)) return;
        BaumKnoten<T> tmp = startWurzel;
        int status;
        while (true) {
            if (comparator != null) status = comparator.compare(tmp.wurzel, element);
            else status = tmp.wurzel.compareTo(element);
            if (status < 0) {
                if (tmp.hasRechts()) tmp = tmp.rechts;
                else {
                    tmp.rechts = new BaumKnoten<>(element);
                    break;
                }
            }
            else {
                if (tmp.hasLinks()) tmp = tmp.links;
                else {
                    tmp.links = new BaumKnoten<>(element);
                    break;
                }
            }
        }
    }

    public boolean contains(T element) {
        if (isEmpty()) return false;
        BaumKnoten<T> tmp = startWurzel;
        int status;
        while (true) {
            if (comparator != null) status = comparator.compare(tmp.wurzel, element);
            else status = tmp.wurzel.compareTo(element);
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
        return hoehe(startWurzel, 1);
    }

    private int hoehe(BaumKnoten<T> element, int counter) {
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
        return size(startWurzel, 1);
    }

    private int size(BaumKnoten<T> element, int counter) {
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

    public FolgeMitDynArray<T> preorder() {
        FolgeMitDynArray<T> result = new FolgeMitDynArray<>();
        result.insert(startWurzel.wurzel);
        if (startWurzel.hasLinks()) result.append(preorder(startWurzel.links));
        if (startWurzel.hasRechts()) result.append(preorder(startWurzel.rechts));
        return result;
    }

    private @NotNull FolgeMitDynArray<T> preorder(@NotNull BaumKnoten<T> baumKnoten) {
        FolgeMitDynArray<T> result = new FolgeMitDynArray<>();
        result.insert(baumKnoten.wurzel);
        if (baumKnoten.hasLinks()) result.append(preorder(baumKnoten.links));
        if (baumKnoten.hasRechts()) result.append(preorder(baumKnoten.rechts));
        return result;
    }

    public FolgeMitDynArray<T> inorder() {
        FolgeMitDynArray<T> result = new FolgeMitDynArray<>();
        if (startWurzel.hasLinks()) result.append(inorder(startWurzel.links));
        result.insert(startWurzel.wurzel);
        if (startWurzel.hasRechts()) result.append(inorder(startWurzel.rechts));
        return result;
    }

    private @NotNull FolgeMitDynArray<T> inorder(@NotNull BaumKnoten<T> baumKnoten) {
        FolgeMitDynArray<T> result = new FolgeMitDynArray<>();
        if (baumKnoten.hasLinks()) result.append(inorder(baumKnoten.links));
        result.insert(baumKnoten.wurzel);
        if (baumKnoten.hasRechts()) result.append(inorder(baumKnoten.rechts));
        return result;
    }

    public FolgeMitDynArray<T> postorder() {
        FolgeMitDynArray<T> result = new FolgeMitDynArray<>();
        if (startWurzel.hasLinks()) result.append(postorder(startWurzel.links));
        if (startWurzel.hasRechts()) result.append(postorder(startWurzel.rechts));
        result.insert(startWurzel.wurzel);
        return result;
    }

    private @NotNull FolgeMitDynArray<T> postorder(@NotNull BaumKnoten<T> baumKnoten) {
        FolgeMitDynArray<T> result = new FolgeMitDynArray<>();
        if (baumKnoten.hasLinks()) result.append(postorder(baumKnoten.links));
        if (baumKnoten.hasRechts()) result.append(postorder(baumKnoten.rechts));
        result.insert(baumKnoten.wurzel);
        return result;
    }

    public FolgeMitDynArray<T> order(@NotNull String str) {
        return switch (str) {
            case "pre", "preorder" -> preorder();
            case "in", "inorder" -> inorder();
            case "post", "postorder" -> postorder();
            default -> null;
        };
    }

    public FolgeMitDynArray<T> breitensuche() {
        int hoehe = hoehe();
        int size = size();
        FolgeMitDynArray<Paar<T, Integer>> prio = breitensucheHilfe(startWurzel, 0);
        FolgeMitDynArray<T> result = new FolgeMitDynArray<>();
        for (int i = 0; i < hoehe; i++)
            for (int j = 0; j < size; j++) if (prio.get(j).getZweites() == i) result.insert(prio.get(j).getErstes());
        return result;
    }

    private @NotNull FolgeMitDynArray<Paar<T, Integer>> breitensucheHilfe(@NotNull BaumKnoten<T> baumKnoten, int h) {
        FolgeMitDynArray<Paar<T, Integer>> result = new FolgeMitDynArray<>();
        T a = baumKnoten.wurzel;
        Integer b = h;
        Paar<T, Integer> paar = new Paar<>(a, b);
        result.insert(paar);
        h++;
        if (baumKnoten.hasLinks()) result.append(breitensucheHilfe(baumKnoten.links, h));
        if (baumKnoten.hasRechts()) result.append(breitensucheHilfe(baumKnoten.rechts, h));
        return result;
    }

    public void remove(T element) {
        BaumKnoten<T> tmpKnoten = search(element);
        if (tmpKnoten == null) return;
        if (startWurzel.equals(tmpKnoten)) {
            BaumKnoten<T> tmpLinks = tmpKnoten.links;
            startWurzel = tmpLinks;
            if (tmpLinks.hasLinks()) insertKnoten(tmpLinks.links);
            if (tmpLinks.hasRechts()) insertKnoten(tmpLinks.rechts);
            if (tmpKnoten.hasRechts()) insertKnoten(tmpKnoten.rechts);
        } else {
            BaumKnoten<T> tmpUpper = searchUpper(element);
            assert tmpUpper != null;
            if (tmpUpper.links.equals(tmpKnoten)) tmpUpper.links = null;
            else if (tmpUpper.rechts.equals(tmpKnoten)) tmpUpper.rechts = null;
            if (tmpKnoten.hasLinks()) insertKnoten(tmpKnoten.links);
            if (tmpKnoten.hasRechts()) insertKnoten(tmpKnoten.rechts);
        }
    }

    private void insertKnoten(@NotNull BaumKnoten<T> baumKnoten) {
        insert(baumKnoten.wurzel);
        if (baumKnoten.hasLinks()) insertKnoten(baumKnoten.links);
        if (baumKnoten.hasRechts()) insertKnoten(baumKnoten.rechts);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return obj instanceof IntSuchbaum equal && this.breitensuche().equals(equal.breitensuche());
    }

    private @Nullable BaumKnoten<T> search(T element) {
        if (isEmpty()) return null;
        BaumKnoten<T> tmp = startWurzel;
        int status;
        while (true) {
            if (comparator != null) status = comparator.compare(tmp.wurzel, element);
            else status = tmp.wurzel.compareTo(element);
            if (status == 0) return tmp;
            if (status < 0) {
                if (tmp.hasRechts()) tmp = tmp.rechts;
                else break;
            }
            else {
                if (tmp.hasLinks()) tmp = tmp.links;
                else break;
            }
        }
        return null;
    }

    private @Nullable BaumKnoten<T> searchUpper(T element) {
        if (isEmpty()) return null;
        BaumKnoten<T> tmp = startWurzel;
        int status;
        while (true) {
            if (comparator != null) status = comparator.compare(tmp.wurzel, element);
            else status = tmp.wurzel.compareTo(element);
            if (status == 0) break;
            if (status < 0) {
                if (tmp.hasRechts()) {
                    if (tmp.rechts.wurzel.equals(element)) return tmp;
                    else tmp = tmp.rechts;
                }
                else break;
            }
            else {
                if (tmp.hasLinks()) {
                    if (tmp.links.wurzel.equals(element)) return tmp;
                    else tmp = tmp.links;
                }
                else break;
            }
        }
        return null;
    }
}
