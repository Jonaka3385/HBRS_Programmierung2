package speicher;

import org.jetbrains.annotations.NotNull;

import static java.lang.Math.abs;
import static java.lang.Math.pow;


public class MyFloat {
    private int vorkomma;
    private int nachkomma;
    private final int potenzierung;

    public MyFloat(int vorkomma, int nachkomma) {
        this.vorkomma = vorkomma;
        this.nachkomma = nachkomma;
        if (nachkomma < 0) {
            this.vorkomma *= -1;
            this.nachkomma = abs(this.nachkomma);
        }
        int stellen = 0;
        int tmp = this.nachkomma;
        while (tmp >= 1) {
            tmp /= 10;
            stellen++;
        }
        this.potenzierung = (int) pow(10, stellen);
    }

    public int vorkomma() {
        return vorkomma;
    }

    public int nachkomma() {
        return nachkomma;
    }

    public int potenzierung() {
        return potenzierung;
    }

    public void neg(){
        vorkomma *= -1;
    }

    public void add(@NotNull MyFloat myFloat) {
        int myVorkomma = myFloat.vorkomma();
        int myNachkomma = myFloat.nachkomma();
        int myPotenziert = myFloat.potenzierung();

        if (potenzierung < myPotenziert) myNachkomma /= (double) myPotenziert / potenzierung;
        else if (potenzierung > myPotenziert) myNachkomma *= (double) potenzierung / myPotenziert;

        vorkomma = vorkomma + myVorkomma;
        nachkomma = nachkomma + myNachkomma;
        while (nachkomma >= potenzierung) {
            vorkomma++;
            nachkomma -= potenzierung;
        }
        while (nachkomma < 0) {
            vorkomma--;
            nachkomma += potenzierung;
        }
    }

    public void sub(@NotNull MyFloat myFloat) {
        int myVorkomma = myFloat.vorkomma();
        int myNachkomma = myFloat.nachkomma();
        int myPotenziert = myFloat.potenzierung();

        if (potenzierung < myPotenziert) myNachkomma /= (double) myPotenziert / potenzierung;
        else if (potenzierung > myPotenziert) myNachkomma *= (double) potenzierung / myPotenziert;

        vorkomma = vorkomma - myVorkomma;
        nachkomma = nachkomma - myNachkomma;
        while (nachkomma >= potenzierung) {
            vorkomma++;
            nachkomma -= potenzierung;
        }
        while (nachkomma < 0) {
            vorkomma--;
            nachkomma += potenzierung;
        }
    }

    public void mul(@NotNull MyFloat myFloat) {
        int myVorkomma = myFloat.vorkomma();
        int myNachkomma = myFloat.nachkomma();
        int myPotenziert = myFloat.potenzierung();

        if (potenzierung < myPotenziert) myNachkomma /= (double) myPotenziert / potenzierung;
        else if (potenzierung > myPotenziert) myNachkomma *= (double) potenzierung / myPotenziert;

        int tmp = (((vorkomma * potenzierung) + nachkomma) * ((myVorkomma * potenzierung) + myNachkomma));

        vorkomma = 0;
        nachkomma = tmp / potenzierung;
        while (nachkomma >= potenzierung) {
            vorkomma++;
            nachkomma -= potenzierung;
        }
        while (nachkomma < 0) {
            vorkomma--;
            nachkomma += potenzierung;
        }
    }

    public void div(@NotNull MyFloat myFloat) {
        int myVorkomma = myFloat.vorkomma();
        int myNachkomma = myFloat.nachkomma();
        int myPotenziert = myFloat.potenzierung();

        if (potenzierung < myPotenziert) myNachkomma /= (double) myPotenziert / potenzierung;
        else if (potenzierung > myPotenziert) myNachkomma *= (double) potenzierung / myPotenziert;

        int tmp = (((vorkomma * potenzierung) + nachkomma) * potenzierung) /
                ((myVorkomma * potenzierung) + myNachkomma);

        vorkomma = 0;
        nachkomma = tmp;
        while (nachkomma >= potenzierung) {
            vorkomma++;
            nachkomma -= potenzierung;
        }
        while (nachkomma < 0) {
            vorkomma--;
            nachkomma += potenzierung;
        }
    }

    @Override
    public String toString() {
        return vorkomma +
                "." +
                nachkomma;
    }
}
