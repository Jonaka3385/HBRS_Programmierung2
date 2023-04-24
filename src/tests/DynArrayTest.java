package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicherKlassen.DynArray;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {
    private DynArray<Integer> dyna;

    @BeforeEach
    void setUp() {
        dyna = new DynArray<>();
    }

    @AfterEach
    void tearDown() {
        dyna = null;
    }

    @Test
    @DisplayName("size Test")
    void testSize() {
        assertEquals(0, dyna.size(), "False empty size");
        dyna = new DynArray<>(0);
        assertEquals(1, dyna.size(), "False size");
    }

    @Test
    @DisplayName("capacity Test")
    void testCapacity() {
        assertEquals(1, dyna.capacity(), "False ,,empty,, capacity");
        dyna = new DynArray<>(0);
        assertEquals(1, dyna.capacity(), "False size");
    }

    @Test
    @DisplayName("get Test")
    void testGet() {
        assertThrows(NoSuchElementException.class, () -> dyna.get(0),"No/False Exception");
        dyna = new DynArray<>(0);
        assertThrows(NoSuchElementException.class, () -> dyna.get(1),"No/False Exception");
        assertEquals(0, dyna.get(0), "False element");
    }

    @Test
    @DisplayName("set Test")
    void testSet() {
        assertThrows(NoSuchElementException.class, () -> dyna.set(0, 2),"No/False Exception");
        dyna = new DynArray<>(0);
        dyna.set(0, 1);
        assertThrows(NoSuchElementException.class, () -> dyna.set(1, 2),"No/False Exception");
        assertEquals(1, dyna.get(0), "element not changed");
    }

    @Test
    @DisplayName("addFirst Test")
    void testAddFirst() {
        dyna.addFirst(0);
        assertEquals(1, dyna.capacity(), "False capacity");
        assertEquals(1, dyna.size(), "False size");
        dyna.addFirst(1);
        assertEquals(2, dyna.capacity(), "False capacity");
        assertEquals(2, dyna.size(), "False size");
        assertEquals(1, dyna.get(0), "False first element");
    }

    @Test
    @DisplayName("addLast Test")
    void testAddLast() {
        dyna.addLast(0);
        assertEquals(1, dyna.capacity(), "False capacity");
        assertEquals(1, dyna.size(), "False size");
        dyna.addLast(1);
        assertEquals(2, dyna.capacity(), "False capacity");
        assertEquals(2, dyna.size(), "False size");
        assertEquals(0, dyna.get(0), "False first element");
    }

    @Test
    @DisplayName("removeFirst Test")
    void testRemoveFirst() {
        assertThrows(NoSuchElementException.class, () -> dyna.removeFirst(), "No/False Exception");
        dyna.addFirst(0);
        dyna.addFirst(1);
        dyna.addFirst(2);
        dyna.addFirst(3);
        assertEquals(3, dyna.removeFirst(), "False remove");
        assertEquals(2, dyna.removeFirst(), "False remove");
        assertEquals(1, dyna.removeFirst(), "False remove");
        assertEquals(2, dyna.capacity(), "False capacity");
    }

    @Test
    @DisplayName("removeLast Test")
    void testRemoveLast() {
        assertThrows(NoSuchElementException.class, () -> dyna.removeLast(), "No/False Exception");
        dyna.addLast(0);
        dyna.addLast(1);
        dyna.addLast(2);
        dyna.addLast(3);
        assertEquals(3, dyna.removeLast(), "False remove");
        assertEquals(2, dyna.removeLast(), "False remove");
        assertEquals(1, dyna.removeLast(), "False remove");
        assertEquals(2, dyna.capacity(), "False capacity");
    }
}
