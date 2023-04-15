package mainClasses;

import speicherKlassen.SchlangeMitArray;
import speicherKlassen.SchlangeMitEVL;

public class TimeTestSchlange {
    private static long start, finish, elapsed;
    private static int c;

    public static void main(String[] args) {
        c = 1;

        start = System.currentTimeMillis();
        SchlangeMitArray<Integer> arr = new SchlangeMitArray<>(100000);
        for (c = 0; c < 100000; c++){
            arr.insert(c);
        }
        for (c = 0; c < 100000; c++){
            arr.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("elapsed Array:" + elapsed);

        c = 1;

        start = System.currentTimeMillis();
        SchlangeMitEVL<Integer> evl = new SchlangeMitEVL<>();
        for (c = 0; c < 100000; c++){
            evl.insert(c);
        }
        for (c = 0; c < 100000; c++){
            evl.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("elapsed EVL:" + elapsed);
    }
}
