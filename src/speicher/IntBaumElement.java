package speicher;

import org.jetbrains.annotations.NotNull;

public class IntBaumElement {
    public IntBaumElement links;
    public Integer wurzel;
    public IntBaumElement rechts;

    public IntBaumElement(Integer element) {
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

        str.append("(");
        if (hasLinks()) str.append(links.toString());
        str.append(")");

        str.append(wurzel.toString());

        str.append("(");
        if (hasRechts()) str.append(rechts.toString());
        str.append(")");

        str.append(")");

        return str.toString();
    }

    public int compare(@NotNull Integer integer) {
        return integer.compareTo(wurzel);
    }
}
