package personen;

public abstract class Person {
    protected String name;
    protected String vorname;

    public Person(String pName, String pVorname){
        name = pName;
        vorname= pVorname;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    @Override
    public String toString() {
        return name + ", " + vorname;
    }

    public boolean equals(Person pPerson){
        if (pPerson == null) return false;
        return (this == pPerson) || (this.name.equals(pPerson.getName()) && this.vorname.equals(pPerson.getVorname()));
    }
}
