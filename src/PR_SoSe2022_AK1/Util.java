package PR_SoSe2022_AK1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

@SuppressWarnings("unused")
public class Util {

    /*
     *
     */
    @Contract(pure = true)
    public static <T> int numElementesInCollection(@NotNull Collection<T> col){
        int counter = 0; // Zähler für die Elemente
        for(T e:col){
            counter++;
        }
        return counter;
    }
}
