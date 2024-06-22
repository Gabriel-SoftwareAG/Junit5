package ai.verisoft;

import ai.verisoft.extensions.TestWatcherExtensionExample;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(TestWatcherExtensionExample.class)
public class TestWatcherDemoTest {

    @Test
    void testSuccess() {
        System.out.println("Executing testSuccess");
        assertEquals(2, 1 + 1);
    }

    @Test
    void testFailure() {
        System.out.println("Executing testFailure");
        fail("This test is meant to fail");
    }

    @Test
    @Disabled("Test is disabled for demonstration purposes")
    void testDisabled() {
        System.out.println("This test should be disabled");
    }

    @Test
    void testAborted() {
        System.out.println("Executing testAborted");
        // Simulating an aborted test
        org.junit.jupiter.api.Assumptions.assumeTrue(false);
    }
}

