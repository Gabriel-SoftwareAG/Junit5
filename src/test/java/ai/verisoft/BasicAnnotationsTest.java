package ai.verisoft;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasicAnnotationsTest {


    @Test
    @Order(1)
    public void testOrder1() {
        System.out.println("This is test 1");
    }

    @Test
    @Order(2)
    public void testOrder2() {
        System.out.println("This is test 2");
    }

    @Test
    @DisplayName("This is a test with a display name")
    public void testDisplayName() {
        System.out.println("This is a test with a display name");
    }

    @Test
    @Tag("Sanity")
    @Disabled
    public void testWithTag() {
        System.out.println("This is a test with a tag");
    }

    @Test
    @Tag("Sanity")
    @Tag("Regression")
    public void testWithMultipleTags() {
        System.out.println("This is a test with multiple tags");
    }

    @Test
    @Tag("Sanity")
    public void testWithRegressionTags() {
        System.out.println("This is a test with regression tags");
    }

    @Test
    @Timeout(1)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(1200);
    }
}
