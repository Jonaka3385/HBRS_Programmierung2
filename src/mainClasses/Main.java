package mainClasses;

import speicherKlassen.*;
import personenKlassen.*;

public class Main {
    public static void main(String[] args) {
        StapelMitArray stapel = new StapelMitArray(10);
        SchlangeMitArray schlange = new SchlangeMitArray(10);
        Student student = new Student("Müller", "Thomas", 1234567);
        Boxer boxer = new Boxer("Müller", "Thomas", 90);
    }
}
