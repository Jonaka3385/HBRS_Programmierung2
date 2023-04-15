package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicherKlassen.SchlangeMitEVL;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    @DisplayName("size Test")
    void testSize() {
    }

    @Test
    @DisplayName("capacity Test")
    void testCapacity() {
    }

    @Test
    @DisplayName("insert Test")
    void testInsert() {
    }

    @Test
    @DisplayName("remove Test")
    void testRemove() {
    }

    @Test
    @DisplayName("front Test")
    void testFront() {
    }
}
