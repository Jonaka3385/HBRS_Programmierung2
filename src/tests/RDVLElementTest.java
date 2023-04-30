package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicher.RDVLElement;

import static org.junit.jupiter.api.Assertions.*;

class RDVLElementTest {
    static RDVLElement<Integer> element;

    @BeforeEach
    void setUp() {
        element = new RDVLElement<>(0);
    }

    @AfterEach
    void tearDown() {
        element = null;
    }

    @Test
    @DisplayName("hasNeighbor Test")
    void testHasNeighbor() {
        assertFalse(element.hasNeighbor(), "HasNeighbor zeigt nicht vorhandene Nachbarn");
        element.next = new RDVLElement<>(1);
        assertFalse(element.hasNeighbor(), "HasNeighbor gibt nicht vorhandene prev an");
        element = new RDVLElement<>(0);
        element.prev = new RDVLElement<>(1);
        assertFalse(element.hasNeighbor(), "HasNeighbor gibt nicht vorhandene next an");
        element.next = new RDVLElement<>(1);
        assertTrue(element.hasNeighbor(), "HasNeighbor zeigt Nachbarn nicht an");
    }

    @Test
    @DisplayName("toString Test")
    void testToString() {
        String str = element.toString();
        assertEquals("0", str, "toString erzeugt falsche Übergabe");
    }
}
