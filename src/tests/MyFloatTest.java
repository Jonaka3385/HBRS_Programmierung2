package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicher.MyFloat;

import static org.junit.jupiter.api.Assertions.*;

class MyFloatTest {
    MyFloat myFloat;

    @BeforeEach
    void setUp() {
        myFloat = new MyFloat(1, 50);
    }

    @AfterEach
    void tearDown() {
        myFloat = null;
    }

    @Test
    @DisplayName("vorkomma Test")
    void testVorkomma() {
        assertEquals(1, myFloat.vorkomma(), "Falsches Vorkomma");
    }

    @Test
    @DisplayName("nachkomma Test")
    void testNachkomma() {
        assertEquals(50, myFloat.nachkomma(), "Falsches Nachkomma");
    }

    @Test
    @DisplayName("potenzierung Test")
    void testPotenziert() {
        assertEquals(100, myFloat.potenzierung(), "Falsche potenzierung");
    }

    @Test
    @DisplayName(" Test")
    void neg() {
        myFloat.neg();
        assertEquals(-1, myFloat.vorkomma(), "False/Not negated");
    }

    @Test
    @DisplayName(" Test")
    void add() {
    }

    @Test
    @DisplayName(" Test")
    void sub() {
    }

    @Test
    @DisplayName(" Test")
    void mul() {
    }

    @Test
    @DisplayName(" Test")
    void div() {
    }

    @Test
    @DisplayName(" Test")
    void testToString() {
    }
}
