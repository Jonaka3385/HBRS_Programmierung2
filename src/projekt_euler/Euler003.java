package projekt_euler;

// Largest Prime Factor
// https://projekteuler.de/problems/3
// https://projecteuler.net/problem=3
public class Euler003 {
    public static long method(long wert) {
        long root = (long) Math.sqrt((double) wert);
        for (long counter = root; counter > 0; counter--) {
            if (wert % counter == 0 && isPrime(counter)) return counter;
        }
        return 0;
    }

    private static boolean isPrime(long wert) {
        for (long counter = 2; counter < wert; counter++) {
            if (wert % counter == 0) return false;
        }
        return true;
    }
}
