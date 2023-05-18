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
        this.potenzierung = (int) Math.pow(10, stellen);
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
        boolean thisVZ = vorkomma >= 0;
        boolean myFloatVZ = myFloat.vorkomma() >= 0;

        if (comp == 0) {
            vorkomma *= 2;
            nachkomma *= 2;
            check();
        } else if (comp > 0) {
            if (thisVZ && myFloatVZ) {
                this.unsignedAdd(myFloat);
            } else if (thisVZ) {
                myFloat.neg();
                this.unsignedSub(myFloat);
            } else if (myFloatVZ) {
                this.neg();
                this.unsignedSub(myFloat);
                this.neg();
            } else {
                this.neg();
                myFloat.neg();
                this.unsignedAdd(myFloat);
                this.neg();
            }
        } else {
            MyFloat tmp = myFloat;
            myFloat = new MyFloat(vorkomma, nachkomma);
            this.vorkomma = tmp.vorkomma();
            this.nachkomma = tmp.nachkomma();
            if (thisVZ && myFloatVZ) {
                this.unsignedAdd(myFloat);
            } else if (thisVZ) {
                myFloat.neg();
                this.unsignedSub(myFloat);
            } else if (myFloatVZ) {
                this.neg();
                this.unsignedSub(myFloat);
                this.neg();
            } else {
                this.neg();
                myFloat.neg();
                this.unsignedAdd(myFloat);
                this.neg();
            }
        }
    }

    public void sub(@NotNull MyFloat myFloat) {
        int myNachkomma = myFloat.nachkomma();
        if (potenzierung < myFloat.potenzierung()) myNachkomma /= (double) myFloat.potenzierung() / potenzierung;
        else if (potenzierung > myFloat.potenzierung()) myNachkomma *= (double) potenzierung / myFloat.potenzierung();

        myFloat = new MyFloat(myFloat.vorkomma(), myNachkomma);
        boolean thisVZ = vorkomma >= 0;
        boolean myFloatVZ = myFloat.vorkomma() >= 0;
        int comp;

        if (thisVZ && myFloatVZ) {
            comp = this.compare(myFloat);
        }
        else if (thisVZ) {
            myFloat.neg();
            comp = this.compare(myFloat);
            myFloat.neg();
        }
        else if (myFloatVZ) {
            this.neg();
            comp = this.compare(myFloat);
            this.neg();
        }
        else {
            comp = this.compare(myFloat);
            comp *= -1;
        }

        if (comp == 0) {
            vorkomma = 0;
            nachkomma = 0;
        } else if (comp > 0) {
            if (thisVZ && myFloatVZ) {
                this.unsignedSub(myFloat);
            } else if (thisVZ) {
                myFloat.neg();
                this.unsignedAdd(myFloat);
            } else if (myFloatVZ) {
                this.neg();
                this.unsignedAdd(myFloat);
                this.neg();
            } else {
                this.neg();
                myFloat.neg();
                this.unsignedSub(myFloat);
                this.neg();
            }
        } else {
            MyFloat tmp = myFloat;
            myFloat = new MyFloat(vorkomma, nachkomma);
            this.vorkomma = tmp.vorkomma();
            this.nachkomma = tmp.nachkomma();
            if (thisVZ && myFloatVZ) {
                this.unsignedSub(myFloat);
                this.neg();
            } else if (thisVZ) {
                this.neg();
                this.unsignedAdd(myFloat);
            } else if (myFloatVZ) {
                myFloat.neg();
                this.unsignedAdd(myFloat);
                this.neg();
            } else {
                this.neg();
                myFloat.neg();
                this.unsignedSub(myFloat);
            }
        }
    }

    public void mul(@NotNull MyFloat myFloat) {
        int myNachkomma = myFloat.nachkomma();
        if (potenzierung < myFloat.potenzierung()) myNachkomma /= (double) myFloat.potenzierung() / potenzierung;
        else if (potenzierung > myFloat.potenzierung()) myNachkomma *= (double) potenzierung / myFloat.potenzierung();

        myFloat = new MyFloat(myFloat.vorkomma(), myNachkomma);
        boolean thisVZ = vorkomma >= 0;
        boolean myFloatVZ = myFloat.vorkomma() >= 0;

        if (thisVZ && myFloatVZ) {
            this.unsignedMul(myFloat);
        } else if (thisVZ) {
            myFloat.neg();
            this.unsignedMul(myFloat);
            this.neg();
        } else if (myFloatVZ) {
            this.neg();
            this.unsignedMul(myFloat);
            this.neg();
        } else {
            this.neg();
            myFloat.neg();
            this.unsignedMul(myFloat);
        }
    }

    public void div(@NotNull MyFloat myFloat) {
        int myNachkomma = myFloat.nachkomma();
        if (potenzierung < myFloat.potenzierung()) myNachkomma /= (double) myFloat.potenzierung() / potenzierung;
        else if (potenzierung > myFloat.potenzierung()) myNachkomma *= (double) potenzierung / myFloat.potenzierung();

        myFloat = new MyFloat(myFloat.vorkomma(), myNachkomma);
        boolean thisVZ = vorkomma >= 0;
        boolean myFloatVZ = myFloat.vorkomma() >= 0;

        if (thisVZ && myFloatVZ) {
            this.unsignedDiv(myFloat);
        } else if (thisVZ) {
            myFloat.neg();
            this.unsignedDiv(myFloat);
            this.neg();
        } else if (myFloatVZ) {
            this.neg();
            this.unsignedDiv(myFloat);
            this.neg();
        } else {
            this.neg();
            myFloat.neg();
            this.unsignedDiv(myFloat);
        }
    }

    public void pow(int exp) {
        if (exp == 0) {
            vorkomma = 1;
            nachkomma = 0;
        } else if (exp > 0) {
            MyFloat tmp = new MyFloat(vorkomma, nachkomma);
            for (int i = 1; i < exp; i++) this.mul(tmp);
        } else {
            MyFloat tmp = new MyFloat(vorkomma, nachkomma);
            exp *= -1;
            for (int i = 0; i < exp; i++) this.mul(tmp);
            this.invert();
        }
    }

    public void invert() {
        MyFloat tmp = new MyFloat(this.vorkomma, this.nachkomma);
        vorkomma = 1;
        nachkomma = 0;
        this.div(tmp);
    }

    private void unsignedAdd(@NotNull MyFloat myFloat) {
        vorkomma += myFloat.vorkomma();
        nachkomma += myFloat.nachkomma();
        check();
    }

    private void unsignedSub(@NotNull MyFloat myFloat) {
        vorkomma -= myFloat.vorkomma();
        nachkomma -= myFloat.nachkomma();
        check();
    }

    private void unsignedMul(@NotNull MyFloat myFloat) {
        int tmp = (((vorkomma * potenzierung) + nachkomma) * ((myFloat.vorkomma() * potenzierung) + myFloat.nachkomma())) / potenzierung;

        vorkomma = 0;
        nachkomma = tmp;
        check();
    }

    private void unsignedDiv(@NotNull MyFloat myFloat) {
        int tmp = (((vorkomma * potenzierung) + nachkomma) * potenzierung) /
                ((myFloat.vorkomma() * potenzierung) + myFloat.nachkomma());

        vorkomma = 0;
        nachkomma = tmp;
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
