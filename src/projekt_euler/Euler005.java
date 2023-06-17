package projekt_euler;

// Smallest Multiple
// https://projekteuler.de/problems/5
// https://projecteuler.net/problem=5
public class Euler005 {
    public static int method(int range) throws IllegalStateException {
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
