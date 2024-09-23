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
package ai.verisoft.lesson3;

import co.verisoft.fw.asserts.SoftAsserts;
import org.junit.jupiter.api.Test;

public class SoftAssertionDemoTest {

    @Test
    public void softAsserTest() {
        SoftAsserts softAsserts = new SoftAsserts();
        boolean condition1 = true;
        boolean condition2 = true;

        // Some test code

        softAsserts.assertTrue(condition1, "Condition 1 should be true");

        // Some more test code
        System.out.println("This is a ");


        softAsserts.assertTrue(condition2, "Condition 2 should be true");

        softAsserts.assertAll();
    }
}
