package tests;

import mainClasses.ProjektEuler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicherKlassen.SchlangeMitArray;

import static org.junit.jupiter.api.Assertions.*;

class ProjektEulerTest {
    @Test
    @DisplayName("findMultiples Test")
    public void testFindMultiples() {
        assertThrows(IllegalStateException.class, () -> ProjektEuler.findMultiples(0), "No/False Exception");
        SchlangeMitArray<Integer> actual = ProjektEuler.findMultiples(10);
        assertEquals(3, actual.remove(), "findMultiples gibt falsche SchlangeMitArray zurück");
        assertEquals(5, actual.remove(), "findMultiples gibt falsche SchlangeMitArray zurück");
        assertEquals(6, actual.remove(), "findMultiples gibt falsche SchlangeMitArray zurück");
        assertEquals(9, actual.remove(), "findMultiples gibt falsche SchlangeMitArray zurück");
    }

    @Test
    @DisplayName("sumMultiples Test")
    public void testSumMultiples() {
        assertThrows(IllegalStateException.class, () -> ProjektEuler.sumMultiples(0), "No/False Exception");
        assertEquals(23, ProjektEuler.sumMultiples(10), "sumMultiples macht Fehler bei Addition");
    }

    @Test
    @DisplayName("quadratDerSumme Test")
    public void testQuadratDerSumme() {
        assertThrows(IllegalStateException.class, () -> ProjektEuler.quadratDerSumme(0), "No/False Exception");
        assertEquals(3025, ProjektEuler.quadratDerSumme(10), "Falsches Quadrat der Summe berechnet");
    }

    @Test
    @DisplayName("summeDerQuadrate Test")
    public void testSummeDerQuadrate() {
        assertThrows(IllegalStateException.class, () -> ProjektEuler.summeDerQuadrate(0), "No/False Exception");
        assertEquals(385, ProjektEuler.summeDerQuadrate(10), "Falsche Summe der Quadrate berechnet");
    }

    @Test
    @DisplayName("differenzQsSq Test")
    public void testDifferenzQsSq() {
        assertThrows(IllegalStateException.class, () -> ProjektEuler.differenzQsSq(0), "No/False Exception");
        assertEquals(2640, ProjektEuler.differenzQsSq(10), "Falsche Differenz aus QsSq berechnet");
    }

    @Test
    @DisplayName("kleinsteGemeinsameVielfache Test")
    public void testKleinsteGemeinsameVielfache() {
        assertThrows(IllegalStateException.class, () -> ProjektEuler.kleinsteGemeinsameVielfache(-1), "No/False Exception");
        assertEquals(2520, ProjektEuler.kleinsteGemeinsameVielfache(10), "Falsches Ergebnis");
    }
}
