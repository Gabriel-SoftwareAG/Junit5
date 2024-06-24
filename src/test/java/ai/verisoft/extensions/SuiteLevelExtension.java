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
