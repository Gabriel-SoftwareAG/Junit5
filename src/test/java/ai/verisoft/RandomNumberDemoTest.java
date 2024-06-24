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
package ai.verisoft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class RandomNumberDemoTest {
    // Use static randomNumber0 field anywhere in the test class,
    // including @BeforeAll or @AfterEach lifecycle methods.
    @Random
    private static Integer randomNumber0;



    // Use randomNumber1 field in test methods and @BeforeEach
    // or @AfterEach lifecycle methods.
    @Random
    private int randomNumber1;

    RandomNumberDemoTest(@Random int randomNumber2) {
        System.out.println("Constructor randomNumber2 = " + randomNumber2);
    }

    @BeforeEach
    void beforeEach(@Random int randomNumber3) {
        System.out.println("BeforeEach randomNumber3 = " + randomNumber3);
    }

    @Test
    void test(@Random int randomNumber4) {
        System.out.println("Test randomNumber4 = " + randomNumber4);
    }
}
