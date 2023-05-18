package personen;

import org.jetbrains.annotations.NotNull;

public class Student extends Person implements Comparable<Student> {
    private final int matrikelnummer;

    public Student(String pName, String pVorname, int pMatrikelnummer){
        super(pName, pVorname);
        matrikelnummer = pMatrikelnummer;
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    @Override
    public String toString(){
        return super.toString() + ", " + matrikelnummer;
    }

    @Override
    public boolean equals(Person pPerson){
        if (pPerson == null) return false;
        if (pPerson == this) return true;
        return super.equals(pPerson) && this.matrikelnummer == ((Student) pPerson).getMatrikelnummer();
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return Integer.compare(matrikelnummer, o.getMatrikelnummer());
    }
}
