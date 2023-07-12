package PR_SoSe2022_AK1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KellerspeicherTest {
    Kellerspeicher<Integer> ks;             // Test-Kellerspeicher deklaration
    int[] ints10 = {8,3,9,2,5,1,8,5,9,2};   // Int-Array zu Testzwecken

    @BeforeEach
    void setUp() {
        ks = new Kellerspeicher<>();        // Neuer Kellerspeicher
    }

    @AfterEach
    void tearDown() {
        ks = null;
    }

    /*
     *  Neues Element == Oberstes?
     */
    @Test
    void pushPeekTest(){
        for (int i:ints10) {
            ks.push(i);
            assertEquals(i, ks.peek());
        }
    }

    /*
     *  Richtige Exception bei pop auf leeren Speicher
     */
    @Test
    void popEmptyExceptionTest(){
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ks.pop());
    }
}
