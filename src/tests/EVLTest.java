package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicher.EVL;
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
    @DisplayName("removeFirst test")
    void testRemoveFirst() {
        assertThrows(NoSuchElementException.class, () -> evl.removeFirst(), "No/False Exception");
        evl.addLast(0);
        evl.addLast(1);
        assertEquals(0, evl.removeFirst(), "Falscher Remove");
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

    @Test
    @DisplayName("zip Test")
    void testZip() {
        evl.addLast(4);
        evl.addLast(1);
        evl.addLast(7);
        EVL<Integer> other = new EVL<>();
        other.addLast(3);
        other.addLast(5);
        other.addLast(2);
        other.addLast(8);
        other.addLast(6);
        evl.zip(other);
        assertEquals("4-3-1-5-7-2-8-6", evl.toString(), "Falsch gezipt");

        evl = new EVL<>();
        other = new EVL<>();
        other.addLast(4);
        other.addLast(1);
        other.addLast(7);
        evl.addLast(3);
        evl.addLast(5);
        evl.addLast(2);
        evl.addLast(8);
        evl.addLast(6);
        evl.zip(other);
        assertEquals("3-4-5-1-2-7-8-6", evl.toString(), "Falsch gezipt");
    }
}
