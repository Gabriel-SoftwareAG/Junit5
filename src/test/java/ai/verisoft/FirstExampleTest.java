package ai.verisoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstExampleTest {

    @Test
    public void testDivide() {
        int result = NumericalUtilities.divide(10, 2);
        Assertions.assertEquals(5, result);
    }

    public static <T extends Number> double divide(T numerator, T denominator) throws IllegalArgumentException {
        if (denominator.doubleValue() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return numerator.doubleValue() / denominator.doubleValue();
    }
}
