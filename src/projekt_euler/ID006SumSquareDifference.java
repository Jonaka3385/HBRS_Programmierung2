package projekt_euler;

// https://projekteuler.de/problems/6
// https://projecteuler.net/problem=6
public class ID006SumSquareDifference {
    private static int quadratDerSumme(int range) throws IllegalStateException {
        if (range <= 0) throw new IllegalStateException();
        int sum = 0;
        for (int i = 1; i <= range; i++) {
            sum += i;
        }
        return (int) Math.pow(sum, 2);
    }

    private static int summeDerQuadrate(int range) throws IllegalStateException {
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
