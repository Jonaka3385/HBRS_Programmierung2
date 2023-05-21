package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projekt_euler.*;
import speicher.Paar;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;


class Euler001Test {
    @Test
    @DisplayName("sumMultiples Test")
    void testSumMultiples() {
        assertThrows(IllegalStateException.class, () -> Euler001.sumMultiples(0), "No/False Exception");
        assertEquals(23, Euler001.sumMultiples(10), "sumMultiples macht Fehler bei Addition");
    }
}


class Euler002Test {
    @Test
    @DisplayName("method Test")
    void testMethod() {
        Paar<Integer, Integer> paar = Euler002.method(1, 2, 4000000);
        assertEquals(4613730, paar.getErstes(), "Falscher erster Wert");
        assertEquals(10, paar.getZweites(), "Falscher zweiter Wert");
        assertThrows(IllegalStateException.class, () -> Euler002.method(1, 2, 1), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> Euler002.method(2, 1, 4000000), "No/False Exception");
    }
}

class Euler003Test {
    @Test
    @DisplayName("method Test")
    void testMethod() {
        assertEquals(29, Euler003.method(13195L), "Falsches Ergebnis");
    }
}


class Euler005Test {
    @Test
    @DisplayName("method Test")
    void testMethod() {
        assertThrows(IllegalStateException.class, () -> Euler005.method(-1), "No/False Exception");
        assertEquals(2520, Euler005.method(10), "Falsches Ergebnis");
    }
}


class Euler006Test {
    @Test
    @DisplayName("differenzQsSq Test")
    void testDifferenzQsSq() {
        assertThrows(IllegalStateException.class, () -> Euler006.differenzQsSq(0), "No/False Exception");
        assertEquals(2640, Euler006.differenzQsSq(10), "Falsche Differenz aus QsSq berechnet");
    }
}

class Euler025Test {
    @Test
    @DisplayName("method Test")
    void testMethod() {
        assertThrows(IllegalStateException.class, () -> Euler025.method(0), "No/False Exception");
        BigInteger expected = BigInteger.valueOf(1836311903);
        assertEquals(expected, Euler025.method(10), "False result");
    }
}
