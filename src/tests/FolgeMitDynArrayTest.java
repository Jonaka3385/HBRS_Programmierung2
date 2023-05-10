package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicher.FolgeMitDynArray;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FolgeMitDynArrayTest {
    private FolgeMitDynArray<Integer> folgeMitDynArray;

    @BeforeEach
    void setUp() {
        folgeMitDynArray = new FolgeMitDynArray<>();
    }

    @AfterEach
    void tearDown() {
        folgeMitDynArray = null;
    }

    @Test
    @DisplayName("isEmpty Test")
    void testIsEmpty() {
        assertTrue(folgeMitDynArray.isEmpty(), "False but empty");
        folgeMitDynArray.insert(0);
        assertFalse(folgeMitDynArray.isEmpty(), "True but not empty");
    }

    @Test
    @DisplayName("size Test")
    void testSize() {
        assertEquals(0, folgeMitDynArray.size(), "False size");
    }

    @Test
    @DisplayName("capacity Test")
    void testCapacity() {
        assertEquals(1, folgeMitDynArray.capacity(), "False capacity");
    }

    @Test
    @DisplayName("get Test")
    void testGet() {
        assertThrows(NoSuchElementException.class, () -> folgeMitDynArray.get(-1), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> folgeMitDynArray.get(0), "No/False Exception");
        folgeMitDynArray.insert(0);
        assertEquals(0, folgeMitDynArray.get(0), "False get");
        assertThrows(IllegalStateException.class, () -> folgeMitDynArray.get(1), "No/False Exception");
        folgeMitDynArray.insert(1);
        assertEquals(0, folgeMitDynArray.get(0), "False get");
        assertThrows(IllegalStateException.class, () -> folgeMitDynArray.get(2), "No/False Exception");
    }

    @Test
    @DisplayName("set Test")
    void testSet() {
        assertThrows(NoSuchElementException.class, () -> folgeMitDynArray.set(-1, 0), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> folgeMitDynArray.set(0, 0), "No/False Exception");
        folgeMitDynArray.insert(0);
        folgeMitDynArray.set(0, 2);
        assertEquals(2, folgeMitDynArray.get(0), "False set");
        assertThrows(IllegalStateException.class, () -> folgeMitDynArray.set(1, 0), "No/False Exception");
        folgeMitDynArray.insert(1);
        folgeMitDynArray.set(1, 3);
        assertEquals(3, folgeMitDynArray.get(1), "False set");
        assertThrows(IllegalStateException.class, () -> folgeMitDynArray.set(2, 0), "No/False Exception");
    }

    @Test
    @DisplayName("insert Test")
    void testInsert() {
        folgeMitDynArray.insert(0);
        assertEquals(0, folgeMitDynArray.get(0), "False insert");
        folgeMitDynArray.insert(1);
        assertEquals(1, folgeMitDynArray.get(1), "False insert");
    }

    @Test
    @DisplayName("insert with pos Test")
    void testInsertPos() {
        assertThrows(NoSuchElementException.class, () -> folgeMitDynArray.insert(-1, 2), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> folgeMitDynArray.insert(2, 2), "No/False Exception");
        folgeMitDynArray.insert(0, 0);
        assertEquals(0, folgeMitDynArray.get(0), "False insert with pos");
        folgeMitDynArray.insert(0, 1);
        assertEquals(1, folgeMitDynArray.get(0), "False insert with pos");
    }

    @Test
    @DisplayName("remove Test")
    void testRemove() {
        assertThrows(NoSuchElementException.class, () -> folgeMitDynArray.remove(), "No/False Exception");
        folgeMitDynArray.insert(0);
        folgeMitDynArray.insert(1);
        assertEquals(0, folgeMitDynArray.remove(), "False remove");
        assertEquals(1, folgeMitDynArray.remove(), "False remove");
    }

    @Test
    @DisplayName("remove with pos Test")
    void testRemovePos() {
        assertThrows(IllegalStateException.class, () -> folgeMitDynArray.remove(0), "No/False Exception");
        assertThrows(NoSuchElementException.class, () -> folgeMitDynArray.remove(-1), "No/False Exception");
        folgeMitDynArray.insert(0);
        folgeMitDynArray.insert(1);
        assertThrows(IllegalStateException.class, () -> folgeMitDynArray.remove(2), "No/False Exception");
        assertEquals(0, folgeMitDynArray.remove(0), "False remove");
        assertEquals(1, folgeMitDynArray.remove(0), "False remove");
    }

    @Test
    @DisplayName("append Test")
    void testAppend() {
        FolgeMitDynArray<Integer> toBeAdded = new FolgeMitDynArray<>();
        folgeMitDynArray.insert(0);
        folgeMitDynArray.insert(1);
        toBeAdded.insert(2);
        toBeAdded.insert(3);
        folgeMitDynArray.append(toBeAdded);
        assertEquals(0, folgeMitDynArray.remove(), "False append");
        assertEquals(1, folgeMitDynArray.remove(), "False append");
        assertEquals(2, folgeMitDynArray.remove(), "False append");
        assertEquals(3, folgeMitDynArray.remove(), "False append");
    }
}
