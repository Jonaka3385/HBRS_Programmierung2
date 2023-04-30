package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicherKlassen.Paar;

import static org.junit.jupiter.api.Assertions.*;

class PaarTest {
    Paar<Integer, String> paar;

    @BeforeEach
    void setUp() {
        paar = new Paar<>(0, "A");
    }

    @AfterEach
    void tearDown() {
        paar = null;
    }

    @Test
    @DisplayName("getErstes Test")
    void testGetErstes() {
        assertEquals(0, paar.getErstes(), "False get1");
    }

    @Test
    @DisplayName("setErstes Test")
    void testSetErstes() {
        paar.setErstes(1);
        assertEquals(1, paar.getErstes(), "False set1");
    }

    @Test
    @DisplayName("getZweites Test")
    void testGetZweites() {
        assertEquals("A", paar.getZweites(), "False get2");
    }

    @Test
    @DisplayName("setZweites Test")
    void testSetZweites() {
        paar.setZweites("B");
        assertEquals("B", paar.getZweites(), "False set2");
    }

    @Test
    @DisplayName("setBeide Test")
    void testSetBeide() {
        paar.setBeide(1, "B");
        assertEquals(1, paar.getErstes(), "False set both first Element");
        assertEquals("B", paar.getZweites(), "False set both second Element");
    }

    @Test
    @DisplayName("equals Test")
    void testEquals() {
        Paar<Integer, String> tmp = paar;
        assertTrue(paar.equals(tmp), "False equals with same Object");
        tmp = new Paar<>(0, "A");
        assertTrue(paar.equals(tmp), "False equals with equal Object");
        tmp = new Paar<>(1, "A");
        assertFalse(paar.equals(tmp), "False true equals with different first");
        tmp = new Paar<>(0, "B");
        assertFalse(paar.equals(tmp), "False true equals with different second");
        tmp = new Paar<>(1, "B");
        assertFalse(paar.equals(tmp), "False true equals with different both");
    }

    @Test
    @DisplayName("toString Test")
    void testToString() {
        assertEquals("0, A", paar.toString(), "False toString");
    }
}