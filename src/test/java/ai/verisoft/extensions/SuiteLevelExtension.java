package ai.verisoft.extensions;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SuiteLevelExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private static boolean didRun = false;
    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {

        if (!didRun) {
            extensionContext.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).put("ExtensionCallback", this);
            System.out.println("This is a suite level extension - beforeAll");
            didRun = true;
        }

    }

    @Override
    public void close() {
        System.out.println("This is a suite level extension - close");
    }
}
