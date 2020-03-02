package lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesterTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
        int[] a = new int[] { 5, 4, 1, 9, 2, 6 };
        Arrays.swapLargestAndSmallest(a);
        assertEquals(a[2],9);
        assertEquals(a[3],1);

        a = new int[] { 1, 4, 1, 9, 2, 6 };
        Arrays.swapLargestAndSmallest(a);
        assertEquals(a[0],9);
        assertEquals(a[3],1);

        a = new int[] { 1, 4, 2, 9, 9, 6 };
        Arrays.swapLargestAndSmallest(a);
        assertEquals(a[0],9);
        assertEquals(a[3],1);

        a = new int[] { 1 };
        Arrays.swapLargestAndSmallest(a);
        assertEquals(a[0],1);

    }

}
