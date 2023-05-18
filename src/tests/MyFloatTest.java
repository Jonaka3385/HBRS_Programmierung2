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
        assertEquals(0, myFloat.vorkomma(), "False subtraction (vorkomma)");
        assertEquals(0, myFloat.nachkomma(), "False subtraction (nachkomma)");

        myFloat = new MyFloat(1, 50);
        myFloat2 = new MyFloat(2, 80);
        myFloat.sub(myFloat2);
        assertEquals(-1, myFloat.vorkomma(), "False subtraction (vorkomma)");
        assertEquals(30, myFloat.nachkomma(), "False subtraction (nachkomma)");

        myFloat = new MyFloat(-1, 50);
        myFloat2 = new MyFloat(2, 80);
        myFloat.sub(myFloat2);
        assertEquals(-4, myFloat.vorkomma(), "False subtraction (vorkomma)");
        assertEquals(30, myFloat.nachkomma(), "False subtraction (nachkomma)");

        myFloat = new MyFloat(-1, 50);
        myFloat2 = new MyFloat(-2, 80);
        myFloat.sub(myFloat2);
        assertEquals(1, myFloat.vorkomma(), "False subtraction (vorkomma)");
        assertEquals(30, myFloat.nachkomma(), "False subtraction (nachkomma)");
    }

    @Test
    @DisplayName("mul Test")
    void testMul() {
        MyFloat myFloat2 = new MyFloat(1, 50);
        myFloat.mul(myFloat2);
        assertEquals(2, myFloat.vorkomma(), "False multiplication (vorkomma)");
        assertEquals(25, myFloat.nachkomma(), "False multiplication (nachkomma)");

        myFloat = new MyFloat(1, 50);
        myFloat2 = new MyFloat(-1, 50);
        myFloat.mul(myFloat2);
        assertEquals(-2, myFloat.vorkomma(), "False multiplication (vorkomma)");
        assertEquals(25, myFloat.nachkomma(), "False multiplication (nachkomma)");

        myFloat = new MyFloat(-1, 50);
        myFloat2 = new MyFloat(1, 50);
        myFloat.mul(myFloat2);
        assertEquals(-2, myFloat.vorkomma(), "False multiplication (vorkomma)");
        assertEquals(25, myFloat.nachkomma(), "False multiplication (nachkomma)");

        myFloat = new MyFloat(-1, 50);
        myFloat2 = new MyFloat(-1, 50);
        myFloat.mul(myFloat2);
        assertEquals(2, myFloat.vorkomma(), "False multiplication (vorkomma)");
        assertEquals(25, myFloat.nachkomma(), "False multiplication (nachkomma)");
    }

    @Test
    @DisplayName("div Test")
    void testDiv() {
        MyFloat myFloat2 = new MyFloat(1, 50);
        myFloat.div(myFloat2);
        assertEquals(1, myFloat.vorkomma(), "False divided (vorkomma)");
        assertEquals(0, myFloat.nachkomma(), "False divided (nachkomma)");

        myFloat = new MyFloat(1, 50);
        myFloat2 = new MyFloat(-1, 50);
        myFloat.div(myFloat2);
        assertEquals(-1, myFloat.vorkomma(), "False divided (vorkomma)");
        assertEquals(0, myFloat.nachkomma(), "False divided (nachkomma)");

        myFloat = new MyFloat(-1, 50);
        myFloat2 = new MyFloat(1, 50);
        myFloat.div(myFloat2);
        assertEquals(-1, myFloat.vorkomma(), "False divided (vorkomma)");
        assertEquals(0, myFloat.nachkomma(), "False divided (nachkomma)");

        myFloat = new MyFloat(-1, 50);
        myFloat2 = new MyFloat(-1, 50);
        myFloat.div(myFloat2);
        assertEquals(1, myFloat.vorkomma(), "False divided (vorkomma)");
        assertEquals(0, myFloat.nachkomma(), "False divided (nachkomma)");
    }

    @Test
    @DisplayName("pow Test")
    void testSqr() {
        myFloat.pow(2);
        assertEquals(2, myFloat.vorkomma(), "False squared (vorkomma)");
        assertEquals(25, myFloat.nachkomma(), "False squared (nachkomma)");

        myFloat = new MyFloat(1, 50);
        myFloat.pow(3);
        assertEquals(3, myFloat.vorkomma(), "False squared (vorkomma)");
        assertEquals(37, myFloat.nachkomma(), "False squared (nachkomma)");
    }

    @Test
    @DisplayName("invert Test")
    void testInvert() {
        myFloat.invert();
        assertEquals(0, myFloat.vorkomma(), "False invert (vorkomma)");
        assertEquals(66, myFloat.nachkomma(), "False invert (nachkomma)");
        myFloat.invert();
        assertEquals(1, myFloat.vorkomma(), "False invert (vorkomma)");
        assertEquals(51, myFloat.nachkomma(), "False invert (nachkomma)");
    }

    @Test
    @DisplayName("toString Test")
    void testToString() {
    }
}
