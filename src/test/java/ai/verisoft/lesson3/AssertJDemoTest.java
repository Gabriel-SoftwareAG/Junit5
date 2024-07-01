package ai.verisoft.lesson3;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class AssertJDemoTest {

    @Test
    void testAssertJ() {
        // given
        String str = "abc";

        // then
        Assertions.assertThat(str).isNotNull()
                .startsWith("a")
                .contains("b")
                .endsWith("c");
    }
}
