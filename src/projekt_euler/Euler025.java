package projekt_euler;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

// 1000-digit Fibonacci Number
// https://projekteuler.de/problems/25
// https://projecteuler.net/problem=25
public class Euler025 {
    public static @NotNull BigInteger method(int max) throws IllegalStateException {
        if (max <= 0) throw new IllegalStateException();
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger tmp;
        while (String.valueOf(a).length() < max) {
            tmp = a;
            a = a.add(b);
            b = tmp;
        }
        a = a.add(b);
        return a;
    }
}
