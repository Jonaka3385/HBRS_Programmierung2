package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import personenKlassen.Boxer;

import static org.junit.jupiter.api.Assertions.*;

public class BoxerTest {
    Boxer boxer;

    @BeforeEach
    void setUp(){
        boxer = new Boxer("Name", "Vorname", 80);
    }

    @AfterEach
    void tearDown() {
        boxer = null;
    }

    @Test
    @DisplayName("getName Test")
    void testGetName(){
        assertEquals("Name", boxer.getName());
    }

    @Test
    @DisplayName("getVorname Test")
    void testGetVorname(){
        assertEquals("Vorname", boxer.getVorname());
    }

    @Test
    @DisplayName("toString Test")
    void testToString(){
        assertEquals("Name, Vorname, 80", boxer.toString());
    }

    @Test
    @DisplayName("getGewicht Test")
    void testGetGewicht(){
        assertEquals(80, boxer.getGewicht());
    }

    @Test
    @DisplayName("equals Test")
    void testEquals(){
        Boxer tmpB = boxer;
        assertTrue(boxer.equals(tmpB), "don't work when same object");
        tmpB = new Boxer("Name", "Vorname", 80);
        assertTrue(boxer.equals(tmpB), "don't work when different Object, with same attributes");
        tmpB = new Boxer("N", "Vorname", 80);
        assertFalse(boxer.equals(tmpB), "true, even when Name different");
        tmpB = new Boxer("Name", "VN", 80);
        assertFalse(boxer.equals(tmpB), "true, even when Vorname different");
        tmpB = new Boxer("Name", "Vorname", 81);
        assertFalse(boxer.equals(tmpB), "true, even when Matrikelnummer different");
        assertFalse(boxer.equals(null), "true, even when null");
    }
}
