package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import speicherKlassen.FolgeMitRing;

import static org.junit.jupiter.api.Assertions.*;

class FolgeMitRingTest {
    private FolgeMitRing<Integer> folgeMitRing;

    @BeforeEach
    void setUp() {
        folgeMitRing = new FolgeMitRing<>(2);
    }

    @AfterEach
    void tearDown() {
        folgeMitRing = null;
    }

    @Test
    void isEmpty() {
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
    void insert() {
    }

    @Test
    void testInsert() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }
}