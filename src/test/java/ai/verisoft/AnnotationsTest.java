package ai.verisoft;

import org.junit.jupiter.api.*;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("MyTag")
public class AnnotationsTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("In the before all tests");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("In the before each test");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("In the after each test");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("In the after all tests");
    }

    @Test
    public void ThisTestWillPass() {
        System.out.println("This test will pass");
        Assertions.assertTrue(true);
    }

    @Test
    public void test2() {
        System.out.println("This test will fail");
        assertEquals(1, 2);
    }

    @Test
    @Tag("MyTag")
    public void externalParameterTest() {
        String parameter = System.getProperty("parameter");
        System.out.println("Parameter value: " + parameter);
        assertEquals("MyParameter", parameter);
    }

    @FastTest
    public void testFast() {
        System.out.println("This is a fast test");
    }
}
