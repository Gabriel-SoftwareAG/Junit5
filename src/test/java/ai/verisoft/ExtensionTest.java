package ai.verisoft;


import ai.verisoft.extensions.ExtensionExample;
import ai.verisoft.extensions.HandlingContextExtension;
import ai.verisoft.extensions.TestResultProcessingExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

//@ExtendWith(ExtensionExample.class)
//@DatabaseAndWebServerExtension
@ExtendWith({/*TestResultProcessingExtension.class,*/ HandlingContextExtension.class})
@Tag("test-result-processing-test")
public class ExtensionTest {

    @RegisterExtension
    static ExtensionExample extensionExample = new ExtensionExample();
    @Test
    @Tag("Regression")
    @DisplayName("This is a test with an extension")
    public void testExtension() {
        System.out.println("This is a test with an extension");
    }
}
