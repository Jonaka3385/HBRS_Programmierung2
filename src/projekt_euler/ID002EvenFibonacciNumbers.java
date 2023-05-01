package projekt_euler;

import speicher.Paar;

public class ID002EvenFibonacciNumbers {
    public static Paar<Integer, Integer> method(int ersterWert, int zweiterWert, int max) throws IllegalStateException {
        if (ersterWert <= 0 || zweiterWert <= 0 || max <= 0) throw new IllegalStateException("Werte muessen groesser gleich 0");
        if (max < ersterWert || max < zweiterWert) throw new IllegalStateException("max darf nicht kleiner als die Startwerte sein");
        if (ersterWert > zweiterWert) throw new IllegalStateException("1. Wert muss groesser oder gleich dem 2. sein.");
        int counter = 0;
        int summe = 0;
        while (ersterWert + zweiterWert <= max) {
            zweiterWert += ersterWert;
            ersterWert = zweiterWert - ersterWert;
            if (zweiterWert % 2 == 0) {
                summe += zweiterWert;
                counter++;
            }
        }
        return new Paar<>(summe, counter);
    }
}
