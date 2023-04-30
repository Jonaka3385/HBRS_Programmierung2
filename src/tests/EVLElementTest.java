package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicher.EVLElement;

import static org.junit.jupiter.api.Assertions.*;

class EVLElementTest {
    static EVLElement<Integer> element;

    @BeforeEach
    void setUp() {
        element = new EVLElement<>(0);
    }

    @AfterEach
    void tearDown() {
        element = null;
    }

    @Test
    @DisplayName("hasNext Test")
    void hasNext() {
        assertFalse(element.hasNext(), "HasNext zeigt nicht vorhandenes nächstes an");
        element.next = new EVLElement<>(1);
        assertTrue(element.hasNext(), "HasNext zeigt nächstes nicht an");
    }

    @Test
    @DisplayName("toString Test")
    void testToString() {
        String str = element.toString();
        assertEquals("0", str, "toString erzeugt falsche Übergabe");
    }
}
