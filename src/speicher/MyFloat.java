package speicher;

import org.jetbrains.annotations.NotNull;

import static java.lang.Math.*;


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
        int myNachkomma = myFloat.nachkomma();
        if (potenzierung < myFloat.potenzierung()) myNachkomma /= (double) myFloat.potenzierung() / potenzierung;
        else if (potenzierung > myFloat.potenzierung()) myNachkomma *= (double) potenzierung / myFloat.potenzierung();

        myFloat = new MyFloat(myFloat.vorkomma(), myNachkomma);
        int comp = this.compare(myFloat);
        boolean thisVZ = vorkomma > 0;
        boolean myFloatVZ = myFloat.vorkomma() > 0;

        if (comp == 0) {
            vorkomma *= 2;
            nachkomma *= 2;
            check();
        } else if (comp > 0) {
            if (thisVZ && myFloatVZ) {
                this.uncheckedAdd(myFloat);
            } else if (thisVZ) {
                myFloat.neg();
                this.uncheckedSub(myFloat);
            } else if (myFloatVZ) {
                this.neg();
                this.uncheckedSub(myFloat);
                this.neg();
            } else {
                this.neg();
                myFloat.neg();
                this.uncheckedAdd(myFloat);
                this.neg();
            }
        } else {
            MyFloat tmp = myFloat;
            myFloat = new MyFloat(vorkomma, nachkomma);
            this.vorkomma = tmp.vorkomma();
            this.nachkomma = tmp.nachkomma();
            if (thisVZ && myFloatVZ) {
                this.uncheckedAdd(myFloat);
            } else if (thisVZ) {
                myFloat.neg();
                this.uncheckedSub(myFloat);
            } else if (myFloatVZ) {
                this.neg();
                this.uncheckedSub(myFloat);
                this.neg();
            } else {
                this.neg();
                myFloat.neg();
                this.uncheckedAdd(myFloat);
                this.neg();
            }
        }
    }

    public void sub(@NotNull MyFloat myFloat) {
        int myNachkomma = myFloat.nachkomma();
        if (potenzierung < myFloat.potenzierung()) myNachkomma /= (double) myFloat.potenzierung() / potenzierung;
        else if (potenzierung > myFloat.potenzierung()) myNachkomma *= (double) potenzierung / myFloat.potenzierung();

        myFloat = new MyFloat(myFloat.vorkomma(), myNachkomma);
        int comp = this.compare(myFloat);
        boolean thisVZ = vorkomma > 0;
        boolean myFloatVZ = myFloat.vorkomma() > 0;

        if (comp == 0) {
            vorkomma = 0;
            nachkomma = 0;
        } else if (comp > 0) {
            if (thisVZ && myFloatVZ) {
                this.uncheckedSub(myFloat);
            } else if (thisVZ) {
                myFloat.neg();
                this.uncheckedAdd(myFloat);
            } else if (myFloatVZ) {
                this.neg();
                this.uncheckedAdd(myFloat);
                this.neg();
            } else {
                this.neg();
                myFloat.neg();
                this.uncheckedSub(myFloat);
                this.neg();
            }
        } else {
            MyFloat tmp = myFloat;
            myFloat = new MyFloat(vorkomma, nachkomma);
            this.vorkomma = tmp.vorkomma();
            this.nachkomma = tmp.nachkomma();
            if (thisVZ && myFloatVZ) {
                this.uncheckedSub(myFloat);
                this.neg();
            } else if (thisVZ) {
                this.neg();
                this.uncheckedAdd(myFloat);
            } else if (myFloatVZ) {
                myFloat.neg();
                this.uncheckedAdd(myFloat);
                this.neg();
            } else {
                this.neg();
                myFloat.neg();
                this.uncheckedSub(myFloat);
            }
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
        check();
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
        check();
    }

    private void uncheckedAdd(@NotNull MyFloat myFloat) {
        vorkomma += myFloat.vorkomma();
        nachkomma += myFloat.nachkomma();
        check();
    }

    private void uncheckedSub(@NotNull MyFloat myFloat) {
        vorkomma -= myFloat.vorkomma();
        nachkomma -= myFloat.nachkomma();
        check();
    }

    private void uncheckedMul(@NotNull MyFloat myFloat) {
        check();
    }

    private void uncheckedDiv(@NotNull MyFloat myFloat) {
        check();
    }

    @Override
    public String toString() {
        return vorkomma +
                "." +
                nachkomma;
    }

    private int compare(@NotNull MyFloat myFloat) {
        int myVorkomma = myFloat.vorkomma();
        int myNachkomma = myFloat.nachkomma();
        int myPotenzierung = myFloat.potenzierung();
        int tmpThisNachkomma = nachkomma;

        if (potenzierung < myPotenzierung) tmpThisNachkomma *= (double) myPotenzierung / potenzierung;
        else if (potenzierung > myPotenzierung) myNachkomma *= (double) potenzierung / myPotenzierung;

        int comp = Integer.compare(vorkomma, myVorkomma);
        if (comp == 0) comp = Integer.compare(tmpThisNachkomma, myNachkomma);
        return comp;
    }

    private void check() {
        while (nachkomma >= potenzierung) {
            vorkomma++;
            nachkomma -= potenzierung;
        }
        while (nachkomma < 0) {
            vorkomma--;
            nachkomma += potenzierung;
        }
    }
}
