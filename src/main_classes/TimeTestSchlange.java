package main_classes;

import speicher.SchlangeMitArray;
import speicher.SchlangeMitEVL;

public class TimeTestSchlange {

    public static void main(String[] args) {
        int c;

        long start = System.currentTimeMillis();
        SchlangeMitArray<Integer> arr = new SchlangeMitArray<>(100000);
        for (c = 0; c < 100000; c++){
            arr.insert(c);
        }
        for (c = 0; c < 100000; c++){
            arr.remove();
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("elapsed Array:" + elapsed);

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
