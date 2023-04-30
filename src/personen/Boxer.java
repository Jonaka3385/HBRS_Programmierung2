package personen;

public class Boxer extends Person{
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
}
