package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicher.IntSuchbaum;

import static org.junit.jupiter.api.Assertions.*;

class IntSuchbaumTest {
    IntSuchbaum intSuchbaum;

    @BeforeEach
    void setUp() {
        intSuchbaum = new IntSuchbaum();
    }

    @AfterEach
    void tearDown() {
        intSuchbaum = null;
    }

    @Test
    @DisplayName("isEmpty Test")
    void testIsEmpty() {
    }

    @Test
    @DisplayName("insert Test")
    void testInsert() {
    }

    @Test
    @DisplayName("contains Test")
    void testContains() {
    }

    @Test
    @DisplayName("toString Test")
    void testToString() {
    }

    @Test
    @DisplayName("hoehe Test")
    void testHoehe() {
    }

    @Test
    @DisplayName("size Test")
    void testSize() {
    }

    @Test
    @DisplayName("preorder Test")
    void testPreorder() {
    }

    @Test
    @DisplayName("inorder Test")
    void testInorder() {
    }

    @Test
    @DisplayName("postorder Test")
    void testPostorder() {
    }

    @Test
    @DisplayName("order Test")
    void testOrder() {
    }

    @Test
    @DisplayName("breitensuche Test")
    void testBreitensuche() {
    }
}
