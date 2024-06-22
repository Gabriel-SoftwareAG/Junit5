package ai.verisoft.extensions;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.Set;

public class HandlingContextExtension implements BeforeEachCallback {

    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create("com", "example", "myextension");

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {

        // Retrieve and print test class name
        Object testInstance = context.getTestInstance().orElse(null);
        System.out.println("Test instance: " + testInstance.getClass().getName());


        // Retrieve and print test method
        Method testMethod = context.getTestMethod().orElse(null);
        System.out.println("Test method: " + (testMethod != null ? testMethod.getName() : "null"));


        // Retrieve and print display name
        String displayName = context.getDisplayName();
        System.out.println("Display name: " + displayName);

        // Retrieve and print unique ID
        String uniqueId = context.getUniqueId();
        System.out.println("Unique ID: " + uniqueId);

        // Retrieve and print tags
        Set<String> tags = context.getTags();
        System.out.println("Tags: " + tags);

        // Store and retrieve a value in the context's store
        ExtensionContext.Store store = context.getStore(NAMESPACE);
        store.put("key", "value");
        String value = store.get("key", String.class);
        System.out.println("Stored value: " + value);
    }
}


