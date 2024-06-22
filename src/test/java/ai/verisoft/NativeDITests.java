package ai.verisoft;

import org.junit.jupiter.api.*;

public class NativeDITests {

    public NativeDITests(TestInfo info) {
        System.out.println("Constructor: " + info.getDisplayName());

    }

    @Tag("TestInfoTest")
    @DisplayName("Test info DI Test")
    @Test
    public void TestInfoDITest(TestInfo info) {
        System.out.println("Tags: " + info.getTags());
        System.out.println("Test class: " + info.getTestClass());
        System.out.println("Test method: " + info.getTestMethod());
    }

    @RepeatedTest(3)
    public void RepetitionDITest(RepetitionInfo info) {
        System.out.println("Current repetition: " + info.getCurrentRepetition());
        System.out.println("Total repetitions: " + info.getTotalRepetitions());
        System.out.println("Failure count: " + info.getFailureCount());
    }
    @AfterEach
    public void afterEach(TestReporter reporter) {
        reporter.publishEntry("after", "report");
    }


}
