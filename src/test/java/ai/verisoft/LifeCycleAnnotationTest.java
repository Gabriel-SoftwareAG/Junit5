package ai.verisoft;

import org.junit.jupiter.api.*;

public class LifeCycleAnnotationTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("In the before all tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("In the after all tests");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("In the before each test");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("In the after each test");
    }

    @Test
    public void test1() {
        System.out.println("test #1");
    }

    @Test
    public void test2() {
        System.out.println("test #2");
        Assertions.assertTrue(false);
    }

}
