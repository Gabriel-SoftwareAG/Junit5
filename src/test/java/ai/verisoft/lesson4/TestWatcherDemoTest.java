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
package ai.verisoft.lesson4;

import ai.verisoft.extensions.TestWatcherExtensionExample;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(TestWatcherExtensionExample.class)
public class TestWatcherDemoTest {

    @Test
    void testSuccess() {
        System.out.println("Executing testSuccess");
        assertEquals(2, 1 + 1);
    }


    @Test
    void testFailure() {
        System.out.println("Executing testFailure");
        fail("This test is meant to fail");
    }


    @Test
    @Disabled("Test is disabled for demonstration purposes")
    void testDisabled() {
        System.out.println("This test should be disabled");
    }


    @Test
    void testAborted() {
        System.out.println("Executing testAborted");
        // Simulating an aborted test
        org.junit.jupiter.api.Assumptions.assumeTrue(false);
    }
}
