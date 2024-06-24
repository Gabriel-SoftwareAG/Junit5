/*
 * (C) Copyright 2024 VeriSoft (http://www.verisoft.co)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
