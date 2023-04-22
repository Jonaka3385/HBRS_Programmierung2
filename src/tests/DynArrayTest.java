package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import speicherKlassen.DynArray;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {
    private DynArray<Integer> dyna;

    @BeforeEach
    void setUp() {
        dyna = new DynArray<>();
    }

    @AfterEach
    void tearDown() {
        dyna = null;
    }

    @Test
    void size() {
    }

    @Test
    void capacity() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void addFirst() {
    }

    @Test
    void addLast() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void removeLast() {
    }
}