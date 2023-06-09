package main_classes;

import speicher.Ringpuffer;

public class Temperatursensor {
    private final Ringpuffer<Float> puffer;

    public Temperatursensor() {
        puffer = new Ringpuffer<>(24);
    }

    public void neueMessung(Float wert) {
        try {
            puffer.addLast(wert);
        } catch (Exception e) {
            puffer.removeFirst();
            puffer.addLast(wert);
        }
    }

    public Float aktuelleTemperatur() {
        Float wert;
        try {
            wert = puffer.get(puffer.size()-1);
        } catch (Exception e) {
            wert = Float.NaN;
        }
        return wert;
    }

    public Float durchschnittsTemperatur() {
        if (puffer.size() == 0) return Float.NaN;
        float wert = 0;
        for (int i = 0; i < puffer.size(); i++) {
            wert += puffer.get(i);
        }
        wert /= puffer.size();
        return wert;
    }

    public void reset() {
        puffer.reset();
    }
}
