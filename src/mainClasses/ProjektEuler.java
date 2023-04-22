package mainClasses;

import speicherKlassen.SchlangeMitArray;

public class ProjektEuler {
    public static SchlangeMitArray<Integer> findMultiples(int range) throws IllegalStateException {
        if (range <= 0) throw new IllegalStateException();
        SchlangeMitArray<Integer> multiples = new SchlangeMitArray<>(range);
        for (Integer i = 1; i < range; i++) {
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
        int result = (int) Math.pow(sum, 2);
        return result;
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
}
