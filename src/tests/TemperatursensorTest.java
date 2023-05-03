package tests;

import main_classes.Temperatursensor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatursensorTest {
    Temperatursensor temperatursensor;

    @BeforeEach
    void setUp() {
        temperatursensor = new Temperatursensor();
    }

    @AfterEach
    void tearDown() {
        temperatursensor = null;
    }

    @Test
    @DisplayName("neueMessung Test")
    void testNeueMessung() {
        for (int i = 0; i < 24; i++) {
            temperatursensor.neueMessung(1.1F);
        }
        temperatursensor.neueMessung(1.2F);
        assertEquals(1.2F, temperatursensor.aktuelleTemperatur(), "Falsch eingefügt");
    }

    @Test
    @DisplayName("aktuelleTemperatur Test")
    void testAktuelleTemperatur() {
        assertEquals(Float.NaN, temperatursensor.aktuelleTemperatur(), "Falsche Rückgabe wenn leer");
        temperatursensor.neueMessung(1.1F);
        temperatursensor.neueMessung(1.2F);
        assertEquals(1.2F, temperatursensor.aktuelleTemperatur(), "Falsches ausgegeben");
    }

    @Test
    @DisplayName("durchschnittsTemperatur Test")
    void testDurchschnittsTemperatur() {
        assertEquals(Float.NaN, temperatursensor.durchschnittsTemperatur(), "Falsche Rückgabe wenn leer");
        temperatursensor.neueMessung(1.5F);
        temperatursensor.neueMessung(3F);
        temperatursensor.neueMessung(4.5F);
        assertEquals(3F, temperatursensor.durchschnittsTemperatur(), "Falscher Durchschnitt");
    }

    @Test
    @DisplayName("reset Test")
    void testReset() {
        temperatursensor.neueMessung(1F);
        temperatursensor.reset();
        assertEquals(Float.NaN, temperatursensor.aktuelleTemperatur(), "Falsche Rückgabe wenn leer");
    }
}
