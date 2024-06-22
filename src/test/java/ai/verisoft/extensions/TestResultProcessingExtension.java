package ai.verisoft.extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


public class TestResultProcessingExtension implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) {
        if(context.getExecutionException().isPresent()) {
            System.out.println("Test failed: " + context.getDisplayName());
        } else {
            System.out.println("Test passed: " + context.getDisplayName());
        }
    }
}
