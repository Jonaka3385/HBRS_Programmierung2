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
        SchlangeMitArray<Integer> actual = ProjektEuler.findMultiples(10);
        assertEquals(3, actual.remove(), "findMultiples gibt falsche SchlangeMitArray zurück");
        assertEquals(5, actual.remove(), "findMultiples gibt falsche SchlangeMitArray zurück");
        assertEquals(6, actual.remove(), "findMultiples gibt falsche SchlangeMitArray zurück");
        assertEquals(9, actual.remove(), "findMultiples gibt falsche SchlangeMitArray zurück");
    }

    @Test
    @DisplayName("sumMultiples Test")
    public void testSumMultiples() {
        assertEquals(23, ProjektEuler.sumMultiples(10), "sumMultiples macht Fehler bei Addition");
    }
}
