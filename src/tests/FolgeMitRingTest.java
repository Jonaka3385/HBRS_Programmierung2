package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicher.FolgeMitRing;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FolgeMitRingTest {
    private FolgeMitRing<Integer> folgeMitRing;

    @BeforeEach
    void setUp() {
        folgeMitRing = new FolgeMitRing<>(2);
    }

    @AfterEach
    void tearDown() {
        folgeMitRing = null;
    }

    @Test
    @DisplayName("isEmpty Test")
    void testIsEmpty() {
        assertTrue(folgeMitRing.isEmpty(), "False but empty");
        folgeMitRing.insert(0);
        assertFalse(folgeMitRing.isEmpty(), "True but not empty");
    }

    @Test
    @DisplayName("size Test")
    void testSize() {
        assertEquals(0, folgeMitRing.size(), "False size");
    }

    @Test
    @DisplayName("capacity Test")
    void testCapacity() {
        assertEquals(2, folgeMitRing.capacity(), "False capacity");
    }

    @Test
    @DisplayName("get Test")
    void testGet() {
        assertThrows(NoSuchElementException.class, () -> folgeMitRing.get(-1), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> folgeMitRing.get(0), "No/False Exception");
        folgeMitRing.insert(0);
        assertEquals(0, folgeMitRing.get(0), "False get");
        assertThrows(IllegalStateException.class, () -> folgeMitRing.get(1), "No/False Exception");
        folgeMitRing.insert(1);
        assertEquals(0, folgeMitRing.get(0), "False get");
        assertThrows(IllegalStateException.class, () -> folgeMitRing.get(2), "No/False Exception");
    }

    @Test
    @DisplayName("set Test")
    void testSet() {
        assertThrows(NoSuchElementException.class, () -> folgeMitRing.set(-1, 0), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> folgeMitRing.set(0, 0), "No/False Exception");
        folgeMitRing.insert(0);
        folgeMitRing.set(0, 2);
        assertEquals(2, folgeMitRing.get(0), "False set");
        assertThrows(IllegalStateException.class, () -> folgeMitRing.set(1, 0), "No/False Exception");
        folgeMitRing.insert(1);
        folgeMitRing.set(1, 3);
        assertEquals(3, folgeMitRing.get(1), "False set");
        assertThrows(IllegalStateException.class, () -> folgeMitRing.set(2, 0), "No/False Exception");
    }

    @Test
    @DisplayName("insert Test")
    void testInsert() {
        folgeMitRing.insert(0);
        assertEquals(0, folgeMitRing.get(0), "False insert");
        folgeMitRing.insert(1);
        assertEquals(1, folgeMitRing.get(1), "False insert");
        assertThrows(IllegalStateException.class, () -> folgeMitRing.insert(2), "No/False Exception");
    }

    @Test
    @DisplayName("insert with pos Test")
    void testInsertPos() {
        assertThrows(NoSuchElementException.class, () -> folgeMitRing.insert(-1, 2), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> folgeMitRing.insert(2, 2), "No/False Exception");
        folgeMitRing.insert(0, 0);
        assertEquals(0, folgeMitRing.get(0), "False insert with pos");
        folgeMitRing.insert(0, 1);
        assertEquals(1, folgeMitRing.get(0), "False insert with pos");
    }

    @Test
    @DisplayName("remove Test")
    void testRemove() {
        assertThrows(NoSuchElementException.class, () -> folgeMitRing.remove(), "No/False Exception");
        folgeMitRing.insert(0);
        folgeMitRing.insert(1);
        assertEquals(0, folgeMitRing.remove(), "False remove");
        assertEquals(1, folgeMitRing.remove(), "False remove");
    }

    @Test
    @DisplayName("remove mit pos Test")
    void testRemovePos() {
        assertThrows(IllegalStateException.class, () -> folgeMitRing.remove(0), "No/False Exception");
        assertThrows(NoSuchElementException.class, () -> folgeMitRing.remove(-1), "No/False Exception");
        folgeMitRing.insert(0);
        folgeMitRing.insert(1);
        assertThrows(IllegalStateException.class, () -> folgeMitRing.remove(2), "No/False Exception");
        assertEquals(0, folgeMitRing.remove(0), "False remove");
        assertEquals(1, folgeMitRing.remove(0), "False remove");
    }
}
