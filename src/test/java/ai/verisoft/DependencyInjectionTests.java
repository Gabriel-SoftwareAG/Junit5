package ai.verisoft;

import org.junit.jupiter.api.*;

public class DependencyInjectionTests {

    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @AfterEach
    public void after(TestReporter reporter) {
        reporter.publishEntry("a key", "a value");
    }

    @Test
    public void test1(TestReporter reporter) {
        reporter.publishEntry("a key", "a value");
        //System.out.println(testInfo.getDisplayName());
    }

    @RepeatedTest(3)
    public void test2(RepetitionInfo info) {
        System.out.println(info.getCurrentRepetition());
    }


}
