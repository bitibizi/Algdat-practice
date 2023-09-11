import Practice.Enhetstest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnhetstestTest {


    @Test
    void minEttElement() {
        int[] a = {5};
        assertDoesNotThrow(() -> Enhetstest.min(a), "Fikk feilmelding på tabell med ett element.");
        assertEquals(0, Enhetstest.min(a), "Fikk ikke null. Forventet null.");
    }

    @Test
    void minTabellEndresIkke() {
        int[] a = {1, 4, 7, 4, 1, 5, 2};
        int[] b = a.clone();
        Enhetstest.min(a);
        assertArrayEquals(b, a, "Dette endret på tabellen.");
    }

}