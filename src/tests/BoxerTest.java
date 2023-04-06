package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import personenKlassen.Boxer;

public class BoxerTest {
    Boxer boxer;

    @BeforeEach
    void neuerBoxer(){
        boxer = new Boxer("Name", "Vorname", 80);
    }

    @Test
    @DisplayName("getName Test")
    void testGetName(){
        Assertions.assertEquals("Name", boxer.getName());
    }

    @Test
    @DisplayName("getVorname Test")
    void testGetVorname(){
        Assertions.assertEquals("Vorname", boxer.getVorname());
    }

    @Test
    @DisplayName("toString Test")
    void testToString(){
        Assertions.assertEquals("Name, Vorname, 80", boxer.toString());
    }

    @Test
    @DisplayName("getGewicht Test")
    void testGetGewicht(){
        Assertions.assertEquals(80, boxer.getGewicht());
    }

    @Test
    @DisplayName("equals Test")
    void testEquals(){
        Boxer tmpB = boxer;
        Assertions.assertTrue(boxer.equals(tmpB), "don't work when same object");
        tmpB = new Boxer("Name", "Vorname", 80);
        Assertions.assertTrue(boxer.equals(tmpB), "don't work when different Object, with same attributes");
        tmpB = new Boxer("N", "Vorname", 80);
        Assertions.assertFalse(boxer.equals(tmpB), "true, even when Name different");
        tmpB = new Boxer("Name", "VN", 80);
        Assertions.assertFalse(boxer.equals(tmpB), "true, even when Vorname different");
        tmpB = new Boxer("Name", "Vorname", 81);
        Assertions.assertFalse(boxer.equals(tmpB), "true, even when Matrikelnummer different");
        Assertions.assertFalse(boxer.equals(null), "true, even when null");
    }
}
