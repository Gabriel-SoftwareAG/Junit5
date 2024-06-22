package ai.verisoft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class RandomNumberDemoTest {
    // Use static randomNumber0 field anywhere in the test class,
    // including @BeforeAll or @AfterEach lifecycle methods.
    @Random
    private static Integer randomNumber0;



    // Use randomNumber1 field in test methods and @BeforeEach
    // or @AfterEach lifecycle methods.
    @Random
    private int randomNumber1;

    RandomNumberDemoTest(@Random int randomNumber2) {
        System.out.println("Constructor randomNumber2 = " + randomNumber2);
    }

    @BeforeEach
    void beforeEach(@Random int randomNumber3) {
        System.out.println("BeforeEach randomNumber3 = " + randomNumber3);
    }

    @Test
    void test(@Random int randomNumber4) {
        System.out.println("Test randomNumber4 = " + randomNumber4);
    }


}
