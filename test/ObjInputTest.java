import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ObjInputTest {
    private SafeInputObj safeInput;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetNonZeroLenString() {
        String input = "Hello\n";
        provideInput(input);

        safeInput = new SafeInputObj();
        String result = safeInput.getNonZeroLenString("Enter something");

        assertEquals("Hello", result);
    }

    @Test
    void testGetRangedInt() {
        String input = "5\n";
        provideInput(input);

        safeInput = new SafeInputObj();
        int result = safeInput.getRangedInt("Enter number", 1, 1000000);

        assertEquals(5, result);
    }

    @Test
    void testGetRangedDouble() {
        String input = "5.0\n";
        provideInput(input);

        safeInput = new SafeInputObj();
        double result = safeInput.getRangedDouble("Enter number", 1, 1000000);

        assertEquals(5.0, result);
    }

    @Test
    void testGetYNYes() {
        String input = "Y\n";  // or "y\n"
        provideInput(input);

        safeInput = new SafeInputObj();
        boolean result = safeInput.getYNConfirm("Continue?");

        assertTrue(result);
    }

    @Test
    void testGetYNNo() {
        String input = "N\n";  // or "n\n"
        provideInput(input);

        safeInput = new SafeInputObj();
        boolean result = safeInput.getYNConfirm("Continue?");

        assertFalse(result);
    }

    private void provideInput(String input) {
        InputStream testInp = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInp);
    }
}
