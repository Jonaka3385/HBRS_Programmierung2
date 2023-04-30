package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projekt_euler.DifferenzDerSummen;
import projekt_euler.KleinsteGemeinsameVielfache;
import projekt_euler.Multiples;

import static org.junit.jupiter.api.Assertions.*;

class DifferenzDerSummenTest {
    @Test
    @DisplayName("differenzQsSq Test")
    public void testDifferenzQsSq() {
        assertThrows(IllegalStateException.class, () -> DifferenzDerSummen.differenzQsSq(0), "No/False Exception");
        assertEquals(2640, DifferenzDerSummen.differenzQsSq(10), "Falsche Differenz aus QsSq berechnet");
    }
}


class KleinsteGemeinsameVielfacheTest {
    @Test
    @DisplayName("method Test")
    public void testKleinsteGemeinsameVielfache() {
        assertThrows(IllegalStateException.class, () -> KleinsteGemeinsameVielfache.method(-1), "No/False Exception");
        assertEquals(2520, KleinsteGemeinsameVielfache.method(10), "Falsches Ergebnis");
    }
}


class MultiplesTest {
    @Test
    @DisplayName("sumMultiples Test")
    public void testSumMultiples() {
        assertThrows(IllegalStateException.class, () -> Multiples.sumMultiples(0), "No/False Exception");
        assertEquals(23, Multiples.sumMultiples(10), "sumMultiples macht Fehler bei Addition");
    }
}
