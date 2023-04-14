package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicherKlassen.EVL;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class EVLTest {
    EVL<Integer> evl;

    @BeforeEach
    void setUp() {
        evl = new EVL<>();
    }

    @AfterEach
    void tearDown() {
        evl = null;
    }

    @Test
    @DisplayName("getFirst Test")
    void testGetFirst() {
        assertThrows(NoSuchElementException.class, () -> evl.getFirst(), "No/False Exception");
        evl.addLast(0);
        evl.addLast(1);
        assertEquals(0, evl.getFirst(), "Falsches First");
    }

    @Test
    @DisplayName("getLast Test")
    void testGetLast() {
        assertThrows(NoSuchElementException.class, () -> evl.getLast(), "No/False Exception");
        evl.addLast(0);
        evl.addLast(1);
        assertEquals(1, evl.getLast(), "Falsches Last");
    }

    @Test
    @DisplayName("addLast Test")
    void testAddLast() {
        evl.addLast(0);
        evl.addLast(1);
        assertEquals(0, evl.getFirst(), "Falsches First");
        assertEquals(1, evl.getLast(), "Falsches Last");
        assertEquals(2, evl.size(), "size nicht mit verändert");
    }

    @Test
    @DisplayName("removeLast test")
    void testRemoveLast() {
        assertThrows(NoSuchElementException.class, () -> evl.removeLast(), "No/False Exception");
        evl.addLast(0);
        evl.addLast(1);
        assertEquals(1, evl.removeLast(), "Falscher Remove");
        assertEquals(1, evl.size(), "Size nicht mit verändert");
    }

    @Test
    @DisplayName("contains Test")
    void testContains() {
        evl.addLast(0);
        evl.addLast(1);
        evl.addLast(2);
        assertTrue(evl.contains(0), "contains false, sollte true");
        assertTrue(evl.contains(1), "contains false, sollte true");
        assertTrue(evl.contains(2), "contains false, sollte true");
        assertFalse(evl.contains(3), "contains true, sollte false");
    }

    @Test
    @DisplayName("size Test")
    void testSize() {
        evl.addLast(0);
        evl.addLast(1);
        assertEquals(2, evl.size(), "Size falsch");
    }

    @Test
    @DisplayName("toString Test")
    void testToString() {
        assertEquals("", evl.toString(), "toString falsch, wenn leer");
        evl.addLast(0);
        evl.addLast(1);
        evl.addLast(2);
        assertEquals("0-1-2", evl.toString(), "toString falsch, wenn nicht leer");
    }
}
