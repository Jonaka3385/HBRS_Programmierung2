package speicher;

import org.jetbrains.annotations.NotNull;

import static java.lang.Math.pow;


public class MyFloat {
    private int vorkomma;
    private int nachkomma;
    private final int potenziert;

    public MyFloat(int vorkomma, int nachkomma, int stellen) {
        this.vorkomma = vorkomma;
        this.nachkomma = nachkomma;
        this.potenziert = (int) pow(10, stellen);
    }

    public int vorkomma() {
        return vorkomma;
    }

    public int nachkomma() {
        return nachkomma;
    }

    public int potenziert() {
        return potenziert;
    }

    public void neg(){
        vorkomma *= -1;
        nachkomma *= -1;
    }

    public void add(@NotNull MyFloat myFloat) {
        int myVorkomma = myFloat.vorkomma();
        int myNachkomma = myFloat.nachkomma();
        int myPotenziert = myFloat.potenziert();

        if (potenziert < myPotenziert) myNachkomma /= (double) myPotenziert / potenziert;
        else if (potenziert > myPotenziert) myNachkomma *= (double) potenziert / myPotenziert;

        vorkomma = vorkomma + myVorkomma;
        nachkomma = nachkomma + myNachkomma;
        while (nachkomma >= potenziert) {
            vorkomma++;
            nachkomma -= potenziert;
        }
        while (nachkomma < 0) {
            vorkomma--;
            nachkomma += potenziert;
        }
    }

    public void sub(@NotNull MyFloat myFloat) {
        int myVorkomma = myFloat.vorkomma();
        int myNachkomma = myFloat.nachkomma();
        int myPotenziert = myFloat.potenziert();

        if (potenziert < myPotenziert) myNachkomma /= (double) myPotenziert / potenziert;
        else if (potenziert > myPotenziert) myNachkomma *= (double) potenziert / myPotenziert;

        vorkomma = vorkomma - myVorkomma;
        nachkomma = nachkomma - myNachkomma;
        while (nachkomma >= potenziert) {
            vorkomma++;
            nachkomma -= potenziert;
        }
        while (nachkomma < 0) {
            vorkomma--;
            nachkomma += potenziert;
        }
    }

    public void mul(@NotNull MyFloat myFloat) {
        int myVorkomma = myFloat.vorkomma();
        int myNachkomma = myFloat.nachkomma();
        int myPotenziert = myFloat.potenziert();

        if (potenziert < myPotenziert) myNachkomma /= (double) myPotenziert / potenziert;
        else if (potenziert > myPotenziert) myNachkomma *= (double) potenziert / myPotenziert;

        int tmp = (((vorkomma * potenziert) + nachkomma) * ((myVorkomma * potenziert) + myNachkomma));

        vorkomma = 0;
        nachkomma = tmp / potenziert;
        while (nachkomma >= potenziert) {
            vorkomma++;
            nachkomma -= potenziert;
        }
        while (nachkomma < 0) {
            vorkomma--;
            nachkomma += potenziert;
        }
    }

    public void div(@NotNull MyFloat myFloat) {
        int myVorkomma = myFloat.vorkomma();
        int myNachkomma = myFloat.nachkomma();
        int myPotenziert = myFloat.potenziert();

        if (potenziert < myPotenziert) myNachkomma /= (double) myPotenziert / potenziert;
        else if (potenziert > myPotenziert) myNachkomma *= (double) potenziert / myPotenziert;

        int tmp = (((vorkomma * potenziert) + nachkomma) * potenziert) /
                ((myVorkomma * potenziert) + myNachkomma);

        vorkomma = 0;
        nachkomma = tmp;
        while (nachkomma >= potenziert) {
            vorkomma++;
            nachkomma -= potenziert;
        }
        while (nachkomma < 0) {
            vorkomma--;
            nachkomma += potenziert;
        }
    }

    @Override
    public String toString() {
        return vorkomma +
                "." +
                nachkomma;
    }
}
