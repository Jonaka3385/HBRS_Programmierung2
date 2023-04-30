package mainClasses;

import speicherKlassen.SchlangeMitArray;

public class ProjektEuler {
    public static SchlangeMitArray<Integer> findMultiples(int range) throws IllegalStateException {
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

    public static int quadratDerSumme(int range) throws IllegalStateException {
        if (range <= 0) throw new IllegalStateException();
        int sum = 0;
        for (int i = 1; i <= range; i++) {
            sum += i;
        }
        return (int) Math.pow(sum, 2);
    }

    public static int summeDerQuadrate(int range) throws IllegalStateException {
        if (range <= 0) throw new IllegalStateException();
        int result = 0;
        for (int i = 1; i <= range; i++) {
            result += (int) Math.pow(i, 2);
        }
        return result;
    }

    public static int differenzQsSq(int range) throws IllegalStateException {
        if (range <= 0) throw new IllegalStateException();
        return (quadratDerSumme(range) - summeDerQuadrate(range));
    }

    public static int kleinsteGemeinsameVielfache(int range) throws IllegalStateException {
        if (range < 0) throw new IllegalStateException();
        int wert = 1;
        while (true) {
            int c = 0;
            for (int i = 1; i <= range; i++) {
                if (wert % i == 0) c++;
            }
            if (c == range) return wert;
            wert++;
        }
    }
}
