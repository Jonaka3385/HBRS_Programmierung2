package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicherKlassen.SchlangeMitArray;
import java.util.NoSuchElementException;

class SchlangeMitArrayTest {
    SchlangeMitArray schlange;

    @BeforeEach
    void schlangeLeer(){
        schlange = new SchlangeMitArray(3);
    }

    @Test
    @DisplayName("isEmpty Test")
    void testIsEmpty(){
        Assertions.assertTrue(schlange.isEmpty(), "isEmpty don't work, when Empty");
        schlange.insert(3);
        Assertions.assertFalse(schlange.isEmpty(), "isEmpty don't work, when not Empty");
    }

    @Test
    @DisplayName("size Test")
    void testSize(){
        Assertions.assertEquals(0, schlange.size(), "size when 0 don't work");
        schlange.insert(3);
        Assertions.assertEquals(1, schlange.size(), "size when not 0 don't work");
    }

    @Test
    @DisplayName("capacity Test")
    void testCapacity(){
        Assertions.assertEquals(3, schlange.capacity());
    }

    @Test
    @DisplayName("insertTest")
    void testInsert(){
        schlange.insert(5);
        Assertions.assertEquals(5, schlange.front(), "not inserted");
        schlange.insert(5);
        schlange.insert(5);
        Assertions.assertThrows(IllegalStateException.class, () -> schlange.insert(5), "No/False Exception");
    }

    @Test
    @DisplayName("remove Test")
    void testRemove(){
        Assertions.assertThrows(NoSuchElementException.class, () -> schlange.remove(), "No/False Exception");
        schlange.insert(5);
        Assertions.assertEquals(5, schlange.remove(), "Not/false remove");
        schlange.insert(5);
        schlange.insert(6);
        Assertions.assertEquals(5, schlange.remove(), "Not/false remove after second insert");
    }

    @Test
    @DisplayName("front Test")
    void testFront(){
        Assertions.assertThrows(NoSuchElementException.class, () -> schlange.front(), "No/False Exception");
        schlange.insert(5);
        Assertions.assertEquals(5, schlange.front(), "not correct front");
        schlange.insert(6);
        Assertions.assertEquals(5, schlange.front(), "not correct front after second insert");
    }
}
