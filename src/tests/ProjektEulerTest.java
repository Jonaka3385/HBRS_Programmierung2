package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projekt_euler.ID002EvenFibonacciNumbers;
import projekt_euler.ID006SumSquareDifference;
import projekt_euler.ID005SmallestMultiple;
import projekt_euler.ID001MultiplesOf3Or5;

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
        ID002EvenFibonacciNumbers.method();
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
