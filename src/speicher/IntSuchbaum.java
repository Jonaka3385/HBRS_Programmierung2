package speicher;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IntSuchbaum {
    IntBaumKnoten startWurzel;

    public IntSuchbaum() {
        startWurzel = null;
    }

    public boolean isEmpty() {
        return startWurzel == null;
    }

    public void insert(Integer integer) {
        if (isEmpty()) startWurzel = new IntBaumKnoten(integer);
        if (contains(integer)) return;
        IntBaumKnoten tmp = startWurzel;
        int status;
        while (true) {
            status = Integer.compare(tmp.wurzel, integer);
            if (status < 0) {
                if (tmp.hasRechts()) tmp = tmp.rechts;
                else {
                    tmp.rechts = new IntBaumKnoten(integer);
                    break;
                }
            }
            else {
                if (tmp.hasLinks()) tmp = tmp.links;
                else {
                    tmp.links = new IntBaumKnoten(integer);
                    break;
                }
            }
        }
    }

    public boolean contains(Integer integer) {
        if (isEmpty()) return false;
        IntBaumKnoten tmp = startWurzel;
        int status;
        while (true) {
            status = Integer.compare(tmp.wurzel, integer);
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

    private int hoehe(IntBaumKnoten element, int counter) {
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

    private int size(IntBaumKnoten element, int counter) {
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
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        result.insert(startWurzel.wurzel);
        if (startWurzel.hasLinks()) result.append(preorder(startWurzel.links));
        if (startWurzel.hasRechts()) result.append(preorder(startWurzel.rechts));
        return result;
    }

    private @NotNull FolgeMitDynArray<Integer> preorder(@NotNull IntBaumKnoten intBaumKnoten) {
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        result.insert(intBaumKnoten.wurzel);
        if (intBaumKnoten.hasLinks()) result.append(preorder(intBaumKnoten.links));
        if (intBaumKnoten.hasRechts()) result.append(preorder(intBaumKnoten.rechts));
        return result;
    }

    public FolgeMitDynArray<Integer> inorder() {
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        if (startWurzel.hasLinks()) result.append(inorder(startWurzel.links));
        result.insert(startWurzel.wurzel);
        if (startWurzel.hasRechts()) result.append(inorder(startWurzel.rechts));
        return result;
    }

    private @NotNull FolgeMitDynArray<Integer> inorder(@NotNull IntBaumKnoten intBaumKnoten) {
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        if (intBaumKnoten.hasLinks()) result.append(inorder(intBaumKnoten.links));
        result.insert(intBaumKnoten.wurzel);
        if (intBaumKnoten.hasRechts()) result.append(inorder(intBaumKnoten.rechts));
        return result;
    }

    public FolgeMitDynArray<Integer> postorder() {
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        if (startWurzel.hasLinks()) result.append(postorder(startWurzel.links));
        if (startWurzel.hasRechts()) result.append(postorder(startWurzel.rechts));
        result.insert(startWurzel.wurzel);
        return result;
    }

    private @NotNull FolgeMitDynArray<Integer> postorder(@NotNull IntBaumKnoten intBaumKnoten) {
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        if (intBaumKnoten.hasLinks()) result.append(postorder(intBaumKnoten.links));
        if (intBaumKnoten.hasRechts()) result.append(postorder(intBaumKnoten.rechts));
        result.insert(intBaumKnoten.wurzel);
        return result;
    }

    public FolgeMitDynArray<Integer> order(@NotNull String str) {
        return switch (str) {
            case "pre", "preorder" -> preorder();
            case "in", "inorder" -> inorder();
            case "post", "postorder" -> postorder();
            default -> null;
        };
    }

    public FolgeMitDynArray<Integer> breitensuche() {
        int hoehe = hoehe();
        int size = size();
        FolgeMitDynArray<Paar<Integer, Integer>> prio = breitensucheHilfe(startWurzel, 0);
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        for (int i = 0; i < hoehe; i++)
            for (int j = 0; j < size; j++) if (prio.get(j).getZweites() == i) result.insert(prio.get(j).getErstes());
        return result;
    }

    private @NotNull FolgeMitDynArray<Paar<Integer, Integer>> breitensucheHilfe(@NotNull IntBaumKnoten intBaumKnoten, int h) {
        FolgeMitDynArray<Paar<Integer, Integer>> result = new FolgeMitDynArray<>();
        Integer a = intBaumKnoten.wurzel;
        Integer b = h;
        Paar<Integer, Integer> paar = new Paar<>(a, b);
        result.insert(paar);
        h++;
        if (intBaumKnoten.hasLinks()) result.append(breitensucheHilfe(intBaumKnoten.links, h));
        if (intBaumKnoten.hasRechts()) result.append(breitensucheHilfe(intBaumKnoten.rechts, h));
        return result;
    }

    public void remove(Integer integer) {
        IntBaumKnoten tmpKnoten = search(integer);
        if (tmpKnoten == null) return;
        if (startWurzel.equals(tmpKnoten)) {
            IntBaumKnoten tmpLinks = tmpKnoten.links;
            startWurzel = tmpLinks;
            if (tmpLinks.hasLinks()) insertKnoten(tmpLinks.links);
            if (tmpLinks.hasRechts()) insertKnoten(tmpLinks.rechts);
            if (tmpKnoten.hasRechts()) insertKnoten(tmpKnoten.rechts);
        } else {
            IntBaumKnoten tmpUpper = searchUpper(integer);
            assert tmpUpper != null;
            if (tmpUpper.links.equals(tmpKnoten)) tmpUpper.links = null;
            else if (tmpUpper.rechts.equals(tmpKnoten)) tmpUpper.rechts = null;
            if (tmpKnoten.hasLinks()) insertKnoten(tmpKnoten.links);
            if (tmpKnoten.hasRechts()) insertKnoten(tmpKnoten.rechts);
        }
    }

    private void insertKnoten(@NotNull IntBaumKnoten intBaumKnoten) {
        insert(intBaumKnoten.wurzel);
        if (intBaumKnoten.hasLinks()) insertKnoten(intBaumKnoten.links);
        if (intBaumKnoten.hasRechts()) insertKnoten(intBaumKnoten.rechts);
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

    private @Nullable IntBaumKnoten search(Integer integer) {
        if (isEmpty()) return null;
        IntBaumKnoten tmp = startWurzel;
        int status;
        while (true) {
            status = Integer.compare(tmp.wurzel, integer);
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

    private @Nullable IntBaumKnoten searchUpper(Integer integer) {
        if (isEmpty()) return null;
        IntBaumKnoten tmp = startWurzel;
        int status;
        while (true) {
            status = Integer.compare(tmp.wurzel, integer);
            if (status == 0) break;
            if (status < 0) {
                if (tmp.hasRechts()) {
                    if (tmp.rechts.wurzel.equals(integer)) return tmp;
                    else tmp = tmp.rechts;
                }
                else break;
            }
            else {
                if (tmp.hasLinks()) {
                    if (tmp.links.wurzel.equals(integer)) return tmp;
                    else tmp = tmp.links;
                }
                else break;
            }
        }
        return null;
    }
}
