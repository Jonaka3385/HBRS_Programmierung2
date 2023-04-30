package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicher.RDVL;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class RDVLTest {
    RDVL<Integer> rdvl;

    @BeforeEach
    void setUp() {
        rdvl = new RDVL<>();
    }

    @AfterEach
    void tearDown() {
        rdvl = null;
    }

    @Test
    @DisplayName("isEmpty Test")
    void testIsEmpty() {
        assertTrue(rdvl.isEmpty(), "False but empty");
        rdvl = new RDVL<>(0);
        assertFalse(rdvl.isEmpty());
    }

    @Test
    @DisplayName("size Test")
    void testSize() {
        assertEquals(0, rdvl.size(), "False size");
        rdvl = new RDVL<>(0);
        assertEquals(1, rdvl.size(), "False size");

    }

    @Test
    @DisplayName("add Test")
    void testAdd() {
        rdvl.add(0);
        assertEquals(1, rdvl.size(), "Size nicht verändert");
        assertEquals(0, rdvl.element(), "not added");
        rdvl.add(1);
        assertEquals(2, rdvl.size(), "Size nicht verändert");
    }

    @Test
    @DisplayName("remove Test")
    void testRemove() {
        assertThrows(NoSuchElementException.class, () -> rdvl.remove(), "No/False Exception");
        rdvl.add(0);
        rdvl.add(1);
        assertEquals(0, rdvl.remove(), "nicht richtig zurückgegeben");
        assertEquals(1, rdvl.size(), "size nicht verändert");
        assertEquals(1, rdvl.remove(), "nicht richtig zurückgegeben");
        assertEquals(0, rdvl.size(), "size nicht verändert");
    }

    @Test
    @DisplayName("element Test")
    void testElement() {
        assertThrows(NoSuchElementException.class, () -> rdvl.element(), "No/False Exception");
        rdvl.add(0);
        assertEquals(0, rdvl.element(), "element falsch zurückgegeben");
    }

    @Test
    @DisplayName("next Test")
    void testNext() {
        assertThrows(NoSuchElementException.class, () -> rdvl.next(0), "No/False Exception");
        rdvl.add(0);
        rdvl.add(1);
        rdvl.add(2);
        rdvl.next(1);
        assertEquals(1, rdvl.element(), "Falsch genexted");
        rdvl.next(3);
        assertEquals(1, rdvl.element(), "Falsch genexted (rundlauf)");

    }

    @Test
    @DisplayName("prev Test")
    void testPrev() {
        assertThrows(NoSuchElementException.class, () -> rdvl.prev(0), "No/False Exception");
        rdvl.add(0);
        rdvl.add(1);
        rdvl.add(2);
        rdvl.prev(1);
        assertEquals(2, rdvl.element(), "Falsch gepreved");
        rdvl.prev(3);
        assertEquals(2, rdvl.element(), "Falsch gepreved (rundlauf)");
    }
}
