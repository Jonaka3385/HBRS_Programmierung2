package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import speicher.FolgeMitDynArray;
import speicher.IntSuchbaum;

import static org.junit.jupiter.api.Assertions.*;

class IntSuchbaumTest {
    IntSuchbaum intSuchbaum;

    @BeforeEach
    void setUp() {
        intSuchbaum = new IntSuchbaum();
    }

    @AfterEach
    void tearDown() {
        intSuchbaum = null;
    }

    @Test
    @DisplayName("isEmpty Test")
    void testIsEmpty() {
        assertTrue(intSuchbaum.isEmpty(), "false but empty");
        intSuchbaum.insert(0);
        assertFalse(intSuchbaum.isEmpty(), "true but not empty");
    }

    @Test
    @DisplayName("insert Test")
    void testInsert() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        assertEquals("(((1)2)3((4)5(7)))", intSuchbaum.toString(), "False insert");
    }

    @Test
    @DisplayName("contains Test")
    void testContains() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        assertTrue(intSuchbaum.contains(3), "False but containing");
        assertTrue(intSuchbaum.contains(2), "False but containing");
        assertTrue(intSuchbaum.contains(5), "False but containing");
        assertTrue(intSuchbaum.contains(4), "False but containing");
        assertTrue(intSuchbaum.contains(1), "False but containing");
        assertTrue(intSuchbaum.contains(7), "False but containing");
        assertFalse(intSuchbaum.contains(0), "True but not containing");
    }

    @Test
    @DisplayName("toString Test")
    void testToString() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        assertEquals("(((1)2)3((4)5(7)))", intSuchbaum.toString(), "False toString");
    }

    @Test
    @DisplayName("hoehe Test")
    void testHoehe() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        assertEquals(3, intSuchbaum.hoehe(), "False hoehe");
    }

    @Test
    @DisplayName("size Test")
    void testSize() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        assertEquals(6, intSuchbaum.size(), "False size");
    }

    @Test
    @DisplayName("preorder Test")
    void testPreorder() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        FolgeMitDynArray<Integer> tmp = new FolgeMitDynArray<>();
        tmp.insert(3);
        tmp.insert(2);
        tmp.insert(1);
        tmp.insert(5);
        tmp.insert(4);
        tmp.insert(7);
        assertEquals(tmp, intSuchbaum.preorder(), "False preorder");
    }

    @Test
    @DisplayName("inorder Test")
    void testInorder() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        FolgeMitDynArray<Integer> tmp = new FolgeMitDynArray<>();
        tmp.insert(1);
        tmp.insert(2);
        tmp.insert(3);
        tmp.insert(4);
        tmp.insert(5);
        tmp.insert(7);
        assertEquals(tmp, intSuchbaum.inorder(), "False inorder");
    }

    @Test
    @DisplayName("postorder Test")
    void testPostorder() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        FolgeMitDynArray<Integer> tmp = new FolgeMitDynArray<>();
        tmp.insert(1);
        tmp.insert(2);
        tmp.insert(4);
        tmp.insert(7);
        tmp.insert(5);
        tmp.insert(3);
        assertEquals(tmp, intSuchbaum.postorder(), "False postorder");
    }

    @Test
    @DisplayName("order Test")
    void testOrder() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        FolgeMitDynArray<Integer> tmp = new FolgeMitDynArray<>();
        tmp.insert(3);
        tmp.insert(2);
        tmp.insert(1);
        tmp.insert(5);
        tmp.insert(4);
        tmp.insert(7);
        assertEquals(tmp, intSuchbaum.order("pre"), "False order pre");
        assertEquals(tmp, intSuchbaum.order("preorder"), "False order preorder");

        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        tmp = new FolgeMitDynArray<>();
        tmp.insert(1);
        tmp.insert(2);
        tmp.insert(3);
        tmp.insert(4);
        tmp.insert(5);
        tmp.insert(7);
        assertEquals(tmp, intSuchbaum.order("in"), "False order in");
        assertEquals(tmp, intSuchbaum.order("inorder"), "False order inorder");

        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        tmp = new FolgeMitDynArray<>();
        tmp.insert(1);
        tmp.insert(2);
        tmp.insert(4);
        tmp.insert(7);
        tmp.insert(5);
        tmp.insert(3);
        assertEquals(tmp, intSuchbaum.order("post"), "False order post");
        assertEquals(tmp, intSuchbaum.order("postorder"), "False order postorder");
    }

    @Test
    @DisplayName("breitensuche Test")
    void testBreitensuche() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        FolgeMitDynArray<Integer> tmp = new FolgeMitDynArray<>();
        tmp.insert(3);
        tmp.insert(2);
        tmp.insert(5);
        tmp.insert(1);
        tmp.insert(4);
        tmp.insert(7);
        assertEquals(tmp, intSuchbaum.breitensuche(), "False preorder");
    }

    @Test
    @DisplayName("remove Test")
    void testRemove() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        intSuchbaum.remove(3);
        assertEquals("((1)2((4)5(7)))", intSuchbaum.toString(), "False remove");
        assertEquals(5, intSuchbaum.size(), "False size after remove");
    }

    @Test
    @DisplayName("equals Test")
    void testEquals() {
        IntSuchbaum tmp = new IntSuchbaum();
        intSuchbaum.insert(0);
        tmp.insert(0);
        assertEquals(intSuchbaum, tmp, "equals should be true");

        intSuchbaum = new IntSuchbaum();
        tmp = new IntSuchbaum();
        intSuchbaum.insert(0);
        tmp.insert(1);
        assertNotEquals(intSuchbaum, tmp, "False equals");

        intSuchbaum.insert(1);
        tmp.insert(0);
        assertNotEquals(intSuchbaum, tmp, "Reihenfolge nicht beachtet");
    }
}
