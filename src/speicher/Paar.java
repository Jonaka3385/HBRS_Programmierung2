package speicher;

public class Paar<E, Z> {
    private E erstes;
    private Z zweites;

    public Paar(E pErstes, Z pZweites){
        erstes = pErstes;
        zweites = pZweites;
    }

    public E getErstes() {
        return erstes;
    }

    public void setErstes(E erstes) {
        this.erstes = erstes;
    }

    public Z getZweites() {
        return zweites;
    }

    public void setZweites(Z zweites) {
        this.zweites = zweites;
    }

    public void setBeide(E erstes, Z zweites){
        this.erstes = erstes;
        this.zweites = zweites;
    }

    public boolean equals(Paar<E, Z> paar){
        if (paar == null) return false;
        if (paar == this) return true;
        return erstes.equals(paar.getErstes()) && zweites.equals(paar.getZweites());
    }

    @Override
    public String toString() {
        return erstes + ", " + zweites;
    }
}
