package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import speicher.MyFloat;

import static org.junit.jupiter.api.Assertions.*;

class MyFloatTest {
    MyFloat myFloat;

    @BeforeEach
    void setUp() {
        myFloat = new MyFloat(1, 50, 2);
    }

    @AfterEach
    void tearDown() {
        myFloat = null;
    }

    @Test
    void vorkomma() {
    }

    @Test
    void nachkomma() {
    }

    @Test
    void potenziert() {
    }

    @Test
    void neg() {
    }

    @Test
    void add() {
    }

    @Test
    void sub() {
    }

    @Test
    void mul() {
    }

    @Test
    void div() {
    }

    @Test
    void testToString() {
    }
}