package tests;

import org.junit.jupiter.api.*;
import speicher.StapelMitArray;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StapelMitArrayTest {
    static StapelMitArray<Integer> stapel;

    @BeforeEach
    void setUp(){
        stapel = new StapelMitArray<>(3);
    }

    @AfterEach
    void tearDown(){
        stapel = null;
    }

    @Test
    @DisplayName("isEmpty Test")
    void testIsEmpty(){
        assertTrue(stapel.isEmpty(), "isEmpty don't work, when Empty");
        stapel.insert(3);
        assertFalse(stapel.isEmpty(), "isEmpty don't work, when not Empty");
    }

    @Test
    @DisplayName("size Test")
    void testSize(){
        assertEquals(0, stapel.size(), "size when 0 don't work");
        stapel.insert(3);
        assertEquals(1, stapel.size(), "size when not 0 don't work");
    }

    @Test
    @DisplayName("capacity Test")
    void testCapacity(){
        assertEquals(3, stapel.capacity());
    }

    @Test
    @DisplayName("insertTest")
    void testInsert(){
        stapel.insert(5);
        assertEquals(1, stapel.size(), "not inserted");
        stapel.insert(5);
        stapel.insert(5);
        assertThrows(IllegalStateException.class, () -> stapel.insert(5), "No/False Exception");
    }

    @Test
    @DisplayName("remove Test")
    void testRemove(){
        assertThrows(NoSuchElementException.class, () -> stapel.remove(), "No/False Exception");
        stapel.insert(5);
        assertEquals(5, stapel.remove(), "Not/false remove");
        stapel.insert(5);
        stapel.insert(6);
        assertEquals(6, stapel.remove(), "Not/false remove after second insert");
    }

    @Test
    @DisplayName("top Test")
    void testTop(){
        assertThrows(NoSuchElementException.class, () -> stapel.top(), "No/False Exception");
        stapel.insert(5);
        assertEquals(5, stapel.top(), "not correct front");
        stapel.insert(6);
        assertEquals(6, stapel.top(), "not correct front after second insert");
    }

    @Test
    @DisplayName("applyToAll")
    void testApplyToAll(){
        stapel.insert(1);
        stapel.insert(2);
        stapel.insert(3);
        stapel.applyToAll(x -> 2*x);
        assertEquals(6, stapel.remove(), "False apply at 2*x 3. Parameter");
        assertEquals(4, stapel.remove(), "False apply at 2*x 2. Parameter");
        assertEquals(2, stapel.remove(), "False apply at 2*x 1. Parameter");
        stapel.insert(1);
        stapel.insert(2);
        stapel.insert(3);
        stapel.applyToAll(x -> x*x);
        assertEquals(9, stapel.remove(), "False apply at x*x 3. Parameter");
        assertEquals(4, stapel.remove(), "False apply at x*x 2. Parameter");
        assertEquals(1, stapel.remove(), "False apply at x*x 1. Parameter");
        StapelMitArray<String> stringStapel = new StapelMitArray<>(10);
        stringStapel.insert("A");
        assertThrows(IllegalStateException.class, () -> stringStapel.applyToAll(x -> x), "No/False Exception");
    }
}
