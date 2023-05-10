package speicher;

import org.jetbrains.annotations.NotNull;

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

    private int hoehe(IntBaumElement element) {
        int counter = 0;
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

    private int hoehe(IntBaumElement element, int counter) {
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

    private int size(IntBaumElement element, int counter) {
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

    private @NotNull FolgeMitDynArray<Integer> preorder(@NotNull IntBaumElement intBaumElement) {
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        result.insert(intBaumElement.wurzel);
        if (intBaumElement.hasLinks()) result.append(preorder(intBaumElement.links));
        if (intBaumElement.hasRechts()) result.append(preorder(intBaumElement.rechts));
        return result;
    }

    public FolgeMitDynArray<Integer> inorder() {
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        if (startWurzel.hasLinks()) result.append(inorder(startWurzel.links));
        result.insert(startWurzel.wurzel);
        if (startWurzel.hasRechts()) result.append(inorder(startWurzel.rechts));
        return result;
    }

    private @NotNull FolgeMitDynArray<Integer> inorder(@NotNull IntBaumElement intBaumElement) {
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        if (intBaumElement.hasLinks()) result.append(inorder(intBaumElement.links));
        result.insert(intBaumElement.wurzel);
        if (intBaumElement.hasRechts()) result.append(inorder(intBaumElement.rechts));
        return result;
    }

    public FolgeMitDynArray<Integer> postorder() {
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        if (startWurzel.hasLinks()) result.append(postorder(startWurzel.links));
        if (startWurzel.hasRechts()) result.append(postorder(startWurzel.rechts));
        result.insert(startWurzel.wurzel);
        return result;
    }

    private @NotNull FolgeMitDynArray<Integer> postorder(@NotNull IntBaumElement intBaumElement) {
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        if (intBaumElement.hasLinks()) result.append(postorder(intBaumElement.links));
        if (intBaumElement.hasRechts()) result.append(postorder(intBaumElement.rechts));
        result.insert(intBaumElement.wurzel);
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
        FolgeMitDynArray<Paar<Integer, Integer>> prio = breitensucheHilfe(startWurzel);
        FolgeMitDynArray<Integer> result = new FolgeMitDynArray<>();
        for (int i = 0; i < hoehe; i++)
            for (int j = 0; j < size; j++) if (prio.get(j).getZweites() == i) result.insert(prio.get(j).getErstes());
        return result;
    }

    private @NotNull FolgeMitDynArray<Paar<Integer, Integer>> breitensucheHilfe(@NotNull IntBaumElement intBaumElement) {
        FolgeMitDynArray<Paar<Integer, Integer>> result = new FolgeMitDynArray<>();
        Integer a = intBaumElement.wurzel;
        Integer b = hoehe(intBaumElement);
        Paar<Integer, Integer> paar = new Paar<>(a, b);
        result.insert(paar);
        if (intBaumElement.hasLinks()) result.append(breitensucheHilfe(intBaumElement.links));
        if (intBaumElement.hasRechts()) result.append(breitensucheHilfe(intBaumElement.rechts));
        return result;
    }
}
