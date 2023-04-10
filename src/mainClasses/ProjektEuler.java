package mainClasses;

import speicherKlassen.SchlangeMitArray;

public class ProjektEuler {
    public static SchlangeMitArray<Integer> findMultiples(int range) {
        SchlangeMitArray<Integer> multiples = new SchlangeMitArray<>(range);
        for (Integer i = 1; i < range; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                multiples.insert(i);
            }
        }
        return multiples;
    }

    public static int sumMultiples(int range) {
        SchlangeMitArray<Integer> multiples = findMultiples(range);
        int sum = 0;
        int l = multiples.size();
        for (int i = 0; i < l; i++) {
            sum += multiples.remove();
        }
        return sum;
    }
}
