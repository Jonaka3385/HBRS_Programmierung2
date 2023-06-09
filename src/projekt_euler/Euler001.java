package projekt_euler;

import org.jetbrains.annotations.NotNull;
import speicher.SchlangeMitArray;

// Multiples of 3 or 5
// https://projekteuler.de/problems/1
// https://projecteuler.net/problem=1
public class Euler001 {
    private static @NotNull SchlangeMitArray<Integer> findMultiples(int range) throws IllegalStateException {
        if (range <= 0) throw new IllegalStateException();
        SchlangeMitArray<Integer> multiples = new SchlangeMitArray<>(range);
        for (int i = 1; i < range; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                multiples.insert(i);
            }
        }
        return multiples;
    }

    public static int sumMultiples(int range) throws IllegalStateException {
        if (range <= 0) throw new IllegalStateException();
        SchlangeMitArray<Integer> multiples = findMultiples(range);
        int sum = 0;
        int l = multiples.size();
        for (int i = 0; i < l; i++) {
            sum += multiples.remove();
        }
        return sum;
    }
}
