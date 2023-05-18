package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projekt_euler.*;
import speicher.Paar;

import static org.junit.jupiter.api.Assertions.*;


class ID001MultiplesOf3Or5Test {
    @Test
    @DisplayName("sumMultiples Test")
    void testSumMultiples() {
        assertThrows(IllegalStateException.class, () -> ID001MultiplesOf3Or5.sumMultiples(0), "No/False Exception");
        assertEquals(23, ID001MultiplesOf3Or5.sumMultiples(10), "sumMultiples macht Fehler bei Addition");
    }
}


class ID002EvenFibonacciNumbersTest {
    @Test
    @DisplayName("method Test")
    void testMethod() {
        Paar<Integer, Integer> paar = ID002EvenFibonacciNumbers.method(1, 2, 4000000);
        assertEquals(4613730, paar.getErstes(), "Falscher erster Wert");
        assertEquals(10, paar.getZweites(), "Falscher zweiter Wert");
        assertThrows(IllegalStateException.class, () -> ID002EvenFibonacciNumbers.method(1, 2, 1), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> ID002EvenFibonacciNumbers.method(2, 1, 4000000), "No/False Exception");
    }
}

class ID0003LargestPrimeFactorTest {
    @Test
    @DisplayName("method Test")
    void testMethod() {
        assertEquals(29, ID0003LargestPrimeFactor.method(13195L), "Falsches Ergebnis");
    }
}


class ID005SmallestMultipleTest {
    @Test
    @DisplayName("method Test")
    void testMethod() {
        assertThrows(IllegalStateException.class, () -> ID005SmallestMultiple.method(-1), "No/False Exception");
        assertEquals(2520, ID005SmallestMultiple.method(10), "Falsches Ergebnis");
    }
}


class ID006SumSquareDifferenceTest {
    @Test
    @DisplayName("differenzQsSq Test")
    void testDifferenzQsSq() {
        assertThrows(IllegalStateException.class, () -> ID006SumSquareDifference.differenzQsSq(0), "No/False Exception");
        assertEquals(2640, ID006SumSquareDifference.differenzQsSq(10), "Falsche Differenz aus QsSq berechnet");
    }
}
