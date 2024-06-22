package ai.verisoft.extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WebServerExtension implements BeforeAllCallback, AfterAllCallback {
    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("Shutting down the web server");
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("Starting the web server");
    }
}
