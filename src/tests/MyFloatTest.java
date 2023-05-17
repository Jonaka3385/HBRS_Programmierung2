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
    @DisplayName("neg Test")
    void testNeg() {
        myFloat.neg();
        assertEquals(-1, myFloat.vorkomma(), "False/Not negated");
    }

    @Test
    @DisplayName("add Test")
    void testAdd() {
        MyFloat myFloat2 = new MyFloat(1, 50);
        myFloat.add(myFloat2);
        assertEquals(3, myFloat.vorkomma(), "False added (vorkomma)");
        assertEquals(0, myFloat.nachkomma(), "False added (nachkomma)");

        myFloat = new MyFloat(-1, 50);
        myFloat2 = new MyFloat(2, 80);
        myFloat.add(myFloat2);
        assertEquals(1, myFloat.vorkomma(), "False added (vorkomma)");
        assertEquals(30, myFloat.nachkomma(), "False added (nachkomma)");

        myFloat = new MyFloat(2, 80);
        myFloat2 = new MyFloat(-1, 50);
        myFloat.add(myFloat2);
        assertEquals(1, myFloat.vorkomma(), "False added (vorkomma)");
        assertEquals(30, myFloat.nachkomma(), "False added (nachkomma)");
    }

    @Test
    @DisplayName("sub Test")
    void testSub() {
        MyFloat myFloat2 = new MyFloat(1, 50);
        myFloat.sub(myFloat2);
        assertEquals(0, myFloat.vorkomma(), "False subbed (vorkomma)");
        assertEquals(0, myFloat.nachkomma(), "False subbed (nachkomma)");

        myFloat = new MyFloat(1, 50);
        myFloat2 = new MyFloat(2, 80);
        myFloat.sub(myFloat2);
        assertEquals(-1, myFloat.vorkomma(), "False subbed (vorkomma)");
        assertEquals(30, myFloat.nachkomma(), "False subbed (nachkomma)");

        myFloat = new MyFloat(-1, 50);
        myFloat2 = new MyFloat(2, 80);
        myFloat.sub(myFloat2);
        assertEquals(-4, myFloat.vorkomma(), "False subbed (vorkomma)");
        assertEquals(30, myFloat.nachkomma(), "False subbed (nachkomma)");
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
