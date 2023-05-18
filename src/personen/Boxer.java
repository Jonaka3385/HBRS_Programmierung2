package personen;

import org.jetbrains.annotations.NotNull;

public class Boxer extends Person implements Comparable<Boxer> {
    private final int gewicht;

    public Boxer(String pName, String pVorname, int pGewicht){
        super(pName, pVorname);
        gewicht = pGewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    @Override
    public String toString(){
        return super.toString() + ", " + gewicht;
    }

    @Override
    public boolean equals(Person pPerson){
        if (pPerson == null) return false;
        if (pPerson == this) return true;
        return super.equals(pPerson) && this.gewicht == ((Boxer) pPerson).getGewicht();
    }

    @Override
    public int compareTo(@NotNull Boxer o) {
        int result;
        result = Integer.compare(gewicht, o.getGewicht());
        if (result == 0) result = super.getName().compareTo(o.getName());
        if (result == 0) result = super.getVorname().compareTo(o.getVorname());
        return result;
    }
}
