package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicherKlassen.StapelMitArray;
import java.util.NoSuchElementException;

class StapelMitArrayTest {
    static StapelMitArray stapel;

    @BeforeEach
    void stapelLeer(){
        stapel = new StapelMitArray(3);
    }

    @Test
    @DisplayName("isEmpty Test")
    void testIsEmpty(){
        Assertions.assertTrue(stapel.isEmpty(), "isEmpty don't work, when Empty");
        stapel.insert(3);
        Assertions.assertFalse(stapel.isEmpty(), "isEmpty don't work, when not Empty");
    }

    @Test
    @DisplayName("size Test")
    void testSize(){
        Assertions.assertEquals(0, stapel.size(), "size when 0 don't work");
        stapel.insert(3);
        Assertions.assertEquals(1, stapel.size(), "size when not 0 don't work");
    }

    @Test
    @DisplayName("capacity Test")
    void testCapacity(){
        Assertions.assertEquals(3, stapel.capacity());
    }

    @Test
    @DisplayName("insertTest")
    void testInsert(){
        stapel.insert(5);
        Assertions.assertEquals(5, stapel.top(), "not inserted");
        stapel.insert(5);
        stapel.insert(5);
        Assertions.assertThrows(IllegalStateException.class, () -> stapel.insert(5), "No/False Exception");
    }

    @Test
    @DisplayName("remove Test")
    void testRemove(){
        Assertions.assertThrows(NoSuchElementException.class, () -> stapel.remove(), "No/False Exception");
        stapel.insert(5);
        Assertions.assertEquals(5, stapel.remove(), "Not/false remove");
        stapel.insert(5);
        stapel.insert(6);
        Assertions.assertEquals(6, stapel.remove(), "Not/false remove after second insert");
    }

    @Test
    @DisplayName("top Test")
    void testTop(){
        Assertions.assertThrows(NoSuchElementException.class, () -> stapel.top(), "No/False Exception");
        stapel.insert(5);
        Assertions.assertEquals(5, stapel.top(), "not correct front");
        stapel.insert(6);
        Assertions.assertEquals(6, stapel.top(), "not correct front after second insert");
    }

    @Test
    @DisplayName("applyToAll")
    void testApplyToAll(){
        stapel.insert(1);
        stapel.insert(2);
        stapel.insert(3);
        stapel.applyToAll(x -> 2*x);
        Assertions.assertEquals(6, stapel.remove());
        Assertions.assertEquals(4, stapel.remove());
        Assertions.assertEquals(2, stapel.remove());
        stapel.insert(1);
        stapel.insert(2);
        stapel.insert(3);
        stapel.applyToAll(x -> x*x);
        Assertions.assertEquals(9, stapel.remove());
        Assertions.assertEquals(4, stapel.remove());
        Assertions.assertEquals(1, stapel.remove());
    }
}
