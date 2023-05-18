package comparater_classes;

import org.jetbrains.annotations.NotNull;
import personen.Boxer;

import java.util.Comparator;

public class ComparatorBoxerGewicht implements Comparator<Boxer> {
    @Override
    public int compare(@NotNull Boxer o1, @NotNull Boxer o2) {
        return Integer.compare(o1.getGewicht(), o2.getGewicht());
    }
}
