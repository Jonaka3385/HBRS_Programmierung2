package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicher.SchlangeMitRing;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SchlangeMitRingTest {
    private SchlangeMitRing<Integer> schlangeMitRing;

    @BeforeEach
    void setUp() {
        schlangeMitRing = new SchlangeMitRing<>(2);
    }

    @AfterEach
    void tearDown() {
        schlangeMitRing = null;
    }

    @Test
    @DisplayName("size Test")
    void testSize() {
        assertEquals(0, schlangeMitRing.size(), "False size");
        schlangeMitRing.insert(0);
        assertEquals(1, schlangeMitRing.size(), "False size");
    }

    @Test
    @DisplayName("capacity Test")
    void testCapacity() {
        assertEquals(2, schlangeMitRing.capacity(), "False capacity");
    }

    @Test
    @DisplayName("isEmpty Test")
    void testIsEmpty() {
        assertTrue(schlangeMitRing.isEmpty(), "False but empty");
        schlangeMitRing.insert(0);
        assertFalse(schlangeMitRing.isEmpty(), "True but not empty");
    }

    @Test
    @DisplayName("front Test")
    void testFront() {
        assertThrows(IllegalStateException.class, () -> schlangeMitRing.front(), "No/False Exception");
        schlangeMitRing.insert(0);
        assertEquals(0, schlangeMitRing.front(), "False front");
        schlangeMitRing.insert(1);
        assertEquals(0, schlangeMitRing.front(), "False front");
    }

    @Test
    @DisplayName("insert Test")
    void testInsert() {
        schlangeMitRing.insert(0);
        assertEquals(0, schlangeMitRing.front(), "False inserted");
        schlangeMitRing.insert(1);
        assertEquals(0, schlangeMitRing.front(), "False inserted");
        assertThrows(IllegalStateException.class, () -> schlangeMitRing.insert(2), "No/False Exception");
    }

    @Test
    @DisplayName("remove Test")
    void testRemove() {
        schlangeMitRing.insert(0);
        schlangeMitRing.insert(1);
        assertEquals(0, schlangeMitRing.remove(), "False remove");
        assertEquals(1, schlangeMitRing.remove(), "False remove");
        assertThrows(NoSuchElementException.class, () -> schlangeMitRing.remove(), "No/False Exception");
    }
}
