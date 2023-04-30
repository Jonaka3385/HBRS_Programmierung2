package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicherKlassen.Ringpuffer;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RingpufferTest {

    Ringpuffer<Integer> ringpuffer;

    @BeforeEach
    void setUp() {
        ringpuffer = new Ringpuffer<>(2);
    }

    @AfterEach
    void tearDown() {
        ringpuffer = null;
    }

    @Test
    @DisplayName("size Test")
    void testSize() {
        assertEquals(0, ringpuffer.size(), "Falsche size");
        ringpuffer.addFirst(0);
        assertEquals(1, ringpuffer.size(), "Falsche size");
    }

    @Test
    @DisplayName("get Test")
    void testGet() {
        assertThrows(NoSuchElementException.class, () -> ringpuffer.get(-1), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> ringpuffer.get(0), "No/False Exception");
        ringpuffer.addFirst(0);
        assertEquals(0, ringpuffer.get(0), "Falsches get");
        assertThrows(IllegalStateException.class, () -> ringpuffer.get(1), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> ringpuffer.get(20), "No/False Exception");
    }

    @Test
    @DisplayName("set Test")
    void testSet() {
        assertThrows(NoSuchElementException.class, () -> ringpuffer.get(-1), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> ringpuffer.get(0), "No/False Exception");
        ringpuffer.addFirst(0);
        ringpuffer.set(0, 1);
        assertEquals(1, ringpuffer.get(0), "Falsches get");
        assertThrows(IllegalStateException.class, () -> ringpuffer.set(1, 0), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> ringpuffer.set(20, 0), "No/False Exception");
    }

    @Test
    @DisplayName("addFirst Test")
    void testAddFirst() {
        ringpuffer.addFirst(0);
        ringpuffer.addFirst(1);
        assertEquals(2, ringpuffer.size(), "size nicht geändert");
        assertEquals(1, ringpuffer.get(0), "Falsche Einfüge Reihenfolge");
        assertEquals(0, ringpuffer.get(1), "Falsche Einfüge Reihenfolge");
        assertThrows(IllegalStateException.class, () -> ringpuffer.addFirst(2), "");
    }

    @Test
    @DisplayName("addLast Test")
    void testAddLast() {
        ringpuffer.addLast(0);
        ringpuffer.addLast(1);
        assertEquals(2, ringpuffer.size(), "size nicht geändert");
        assertEquals(1, ringpuffer.get(1), "Falsche Einfüge Reihenfolge");
        assertEquals(0, ringpuffer.get(0), "Falsche Einfüge Reihenfolge");
        assertThrows(IllegalStateException.class, () -> ringpuffer.addLast(2), "");
    }

    @Test
    @DisplayName("removeFirst Test")
    void testRemoveFirst() {
        ringpuffer.addFirst(0);
        ringpuffer.addFirst(1);
        assertEquals(1, ringpuffer.removeFirst(), "False remove");
        assertEquals(0, ringpuffer.removeFirst(), "False remove");
        assertThrows(NoSuchElementException.class, () -> ringpuffer.removeFirst(), "False/No Exception");
    }

    @Test
    @DisplayName("removeLast Test")
    void testRemoveLast() {
        ringpuffer.addLast(0);
        ringpuffer.addLast(1);
        assertEquals(1, ringpuffer.removeLast(), "False remove");
        assertEquals(0, ringpuffer.removeLast(), "False remove");
        assertThrows(NoSuchElementException.class, () -> ringpuffer.removeLast(), "False/No Exception");
    }
}
