package tests;

import main_classes.Josephus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JosephusTest {
    private Josephus josephus;

    @BeforeEach
    void setUp() {
        josephus = new Josephus();
    }

    @AfterEach
    void tearDown() {
        josephus = null;
    }

    @Test
    @DisplayName("loese Test")
    void testLoese() {
        assertThrows(IllegalStateException.class, () -> josephus.loese(0, 2), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> josephus.loese(5, 0), "No/False Exception");
        assertThrows(IllegalStateException.class, () -> josephus.loese(0, 0), "No/False Exception");
        assertEquals(3, josephus.loese(5, 2), "");
    }
}