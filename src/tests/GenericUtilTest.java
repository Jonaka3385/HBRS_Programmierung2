package tests;

import main_classes.GenericUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import speicher.Folge;
import speicher.FolgeMitDynArray;
import speicher.Puffer;
import speicher.Ringpuffer;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class GenericUtilTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void gambling() {
    }

    @Test
    void testGambling() {
    }

    @Test
    void arrayToSchlange() {
    }

    @Test
    void printAll() {
    }

    @Test
    void insertInto() {
    }

    @Test
    void testInsertInto() {
    }

    @Test
    public void testGetMinima() {
        Puffer<Integer> puffer1 = new FolgeMitDynArray<>();
        puffer1.insert(1);
        puffer1.insert(3);
        puffer1.insert(5);

        Puffer<Integer> puffer2 = new FolgeMitDynArray<>();
        puffer2.insert(2);
        puffer2.insert(4);
        puffer2.insert(6);

        Folge<Integer> result = GenericUtil.getMinima(puffer1, puffer2);
        Folge<Integer> folge = new FolgeMitDynArray<>();
        folge.insert(1);
        folge.insert(3);
        folge.insert(5);

        assertEquals(folge.remove(), result.remove());
        assertEquals(folge.remove(), result.remove());
        assertEquals(folge.remove(), result.remove());
    }

    @Test
    public void testGetMinimaWithComparator() {
        Puffer<String> puffer1 = new FolgeMitDynArray<>();
        puffer1.insert("apple");
        puffer1.insert("banana");
        puffer1.insert("cherry");

        Puffer<String> puffer2 = new FolgeMitDynArray<>();
        puffer2.insert("orange");
        puffer2.insert("kiwi");
        puffer2.insert("mango");

        Comparator<String> lengthComparator = Comparator.comparing(String::length);

        Folge<String> result = GenericUtil.getMinima(puffer1, puffer2, lengthComparator);
        Folge<String> folge = new FolgeMitDynArray<>();
        folge.insert("apple");
        folge.insert("kiwi");
        folge.insert("mango");

        assertEquals(folge.remove(), result.remove());
        assertEquals(folge.remove(), result.remove());
        assertEquals(folge.remove(), result.remove());
    }
}
