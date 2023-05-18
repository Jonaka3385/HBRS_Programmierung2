package speicher;

public class BaumKnoten<T> {
    public BaumKnoten<T> links;
    public T wurzel;
    public BaumKnoten<T> rechts;

    public BaumKnoten(T element) {
        links = null;
        wurzel = element;
        rechts = null;
    }

    public boolean hasLinks() {
        return links != null;
    }

    public boolean hasRechts() {
        return rechts != null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("(");

        if (hasLinks()) str.append(links.toString());

        str.append(wurzel.toString());

        if (hasRechts()) str.append(rechts.toString());

        str.append(")");

        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BaumKnoten<?> iBK) {
            boolean b1 = wurzel.equals(iBK.wurzel);

            boolean b2;
            if (links == null && iBK.links == null) b2 = true;
            else if (links == null || iBK.links == null) b2 = false;
            else b2 = links.equals(iBK.links);

            boolean b3;
            if (rechts == null && iBK.rechts == null) b3 = true;
            else if (rechts == null || iBK.rechts == null) b3 = false;
            else b3 = rechts.equals(iBK.rechts);

            return b1 && b2 && b3;
        }
        return false;
    }
}
