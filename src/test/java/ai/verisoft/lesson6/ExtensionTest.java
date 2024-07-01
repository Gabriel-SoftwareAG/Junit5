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
package ai.verisoft.lesson6;


import ai.verisoft.extensions.ExtensionExample;
import ai.verisoft.extensions.HandlingContextExtension;
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
