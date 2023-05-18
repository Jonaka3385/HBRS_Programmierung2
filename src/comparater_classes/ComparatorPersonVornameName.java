package comparater_classes;

import org.jetbrains.annotations.NotNull;
import personen.Person;

import java.util.Comparator;

public class ComparatorPersonVornameName implements Comparator<Person> {
    @Override
    public int compare(@NotNull Person o1, @NotNull Person o2) {
        int result = o1.getVorname().compareTo(o2.getVorname());
        if (result == 0) result = o1.getName().compareTo(o2.getName());
        return result;
    }
}
