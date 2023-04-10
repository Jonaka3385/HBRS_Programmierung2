package tests;

import org.junit.jupiter.api.*;
import speicherKlassen.SchlangeMitArray;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SchlangeMitArrayTest {
    SchlangeMitArray<Integer> schlange;

    @BeforeEach
    void setUp(){
        schlange = new SchlangeMitArray<>(3);
    }

    @AfterEach
    void tearDown(){
        schlange = null;
    }

    @Test
    @DisplayName("isEmpty Test")
    void testIsEmpty(){
        assertTrue(schlange.isEmpty(), "isEmpty don't work, when Empty");
        schlange.insert(3);
        assertFalse(schlange.isEmpty(), "isEmpty don't work, when not Empty");
    }

    @Test
    @DisplayName("size Test")
    void testSize(){
        assertEquals(0, schlange.size(), "size when 0 don't work");
        schlange.insert(3);
        assertEquals(1, schlange.size(), "size when not 0 don't work");
    }

    @Test
    @DisplayName("capacity Test")
    void testCapacity(){
        assertEquals(3, schlange.capacity());
    }

    @Test
    @DisplayName("insertTest")
    void testInsert(){
        schlange.insert(5);
        assertEquals(5, schlange.front(), "not inserted");
        schlange.insert(5);
        schlange.insert(5);
        assertThrows(IllegalStateException.class, () -> schlange.insert(5), "No/False Exception");
    }

    @Test
    @DisplayName("remove Test")
    void testRemove(){
        assertThrows(NoSuchElementException.class, () -> schlange.remove(), "No/False Exception");
        schlange.insert(5);
        assertEquals(5, schlange.remove(), "Not/false remove");
        assertThrows(NoSuchElementException.class, () -> schlange.remove(), "No/False Exception");
        schlange.insert(5);
        schlange.insert(6);
        assertEquals(5, schlange.remove(), "Not/false remove after second insert");
        assertEquals(6, schlange.remove(), "Not/false remove after second insert");
        assertThrows(NoSuchElementException.class, () -> schlange.remove(), "No/False Exception");
    }

    @Test
    @DisplayName("front Test")
    void testFront(){
        assertThrows(NoSuchElementException.class, () -> schlange.front(), "No/False Exception");
        schlange.insert(5);
        assertEquals(5, schlange.front(), "not correct front");
        schlange.insert(6);
        assertEquals(5, schlange.front(), "not correct front after second insert");
    }
}
