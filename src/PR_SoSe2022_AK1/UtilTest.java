package PR_SoSe2022_AK1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {
    Collection<Integer> col0, col10;        // Collection fuer Tests
    int[] ints10 = {8,3,9,2,5,1,8,5,9,2};   // int-array fuer Test

    @BeforeEach
    void setUp() {
        col0 = new ArrayList<>();           // leere Collection
        col10 = new ArrayList<>();          // gefuellte Collection
        for(int i:ints10){
            col10.add(i);
        }
    }

    @AfterEach
    void tearDown(){
        col0 = null;
        col10 = null;
    }

    /*
     *  Test auf richtige Bestimmung der Anzahl von Elementen in Collections
     */
    @Test
    void countElementesInCollection() {
        assertEquals(0, Util.numElementesInCollection(col0));
        assertEquals(ints10.length, Util.numElementesInCollection(col10));
    }
}
