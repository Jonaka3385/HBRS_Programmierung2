package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicher.SchlangeMitEVL;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SchlangeMitEVLTest {

    private static SchlangeMitEVL<Integer> s_evl;

    @BeforeEach
    void setUp() {
        s_evl = new SchlangeMitEVL<>();
    }

    @AfterEach
    void tearDown() {
        s_evl = null;
    }

    @Test
    @DisplayName("is Empty Test")
    void testIsEmpty() {
        assertTrue(s_evl.isEmpty(), "isEmpty False, but empty");
        s_evl.insert(0);
        assertFalse(s_evl.isEmpty(), "isEmpty True, but not empty");
    }

    @Test
    @DisplayName("size Test")
    void testSize() {
        assertEquals(0, s_evl.size(), "Wrong size");
        s_evl.insert(0);
        assertEquals(1, s_evl.size(), "Wrong size");
        s_evl.insert(1);
        assertEquals(2, s_evl.size(), "Wrong size");
    }

    @Test
    @DisplayName("capacity Test")
    void testCapacity() {
        assertEquals(Integer.MAX_VALUE, s_evl.capacity(), "wrong capacity filler");
    }

    @Test
    @DisplayName("insert Test")
    void testInsert() {
        s_evl.insert(0);
        s_evl.insert(1);
        assertEquals(2, s_evl.size(), "size nicht verändert");
        assertEquals(0, s_evl.front(), "Falsch inserted");
    }

    @Test
    @DisplayName("remove Test")
    void testRemove() {
        assertThrows(NoSuchElementException.class, () -> s_evl.remove(), "No/False Exception");
        s_evl.insert(0);
        s_evl.insert(1);
        assertEquals(0, s_evl.remove(), "Falscher Remove");
        assertEquals(1, s_evl.size(), "size nicht verändert");
    }

    @Test
    @DisplayName("front Test")
    void testFront() {
        assertThrows(NoSuchElementException.class, () -> s_evl.front(), "No/False Exception");
        s_evl.insert(0);
        s_evl.insert(1);
        s_evl.insert(2);
        assertEquals(0, s_evl.front(), "Falsch inserted");
        s_evl.remove();
        assertEquals(1, s_evl.front(), "Falsch inserted");
    }
}
