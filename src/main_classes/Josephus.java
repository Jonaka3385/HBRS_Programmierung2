package main_classes;

import speicher.RDVL;

public class Josephus {
    public int loese(int n, int k) throws IllegalStateException {
        if (n <= 0 || k <= 0) throw new IllegalStateException("n muss größer 0 sein");
        RDVL<Integer> r = new RDVL<>();
        for (int i = 1; i <= n; i++) {
            r.add(i);
        }
        for (int i = 1; i < n; i++) {
            r.next(k-1);
            r.remove();
        }
        return r.element();
    }
}
