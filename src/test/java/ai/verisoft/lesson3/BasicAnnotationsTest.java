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

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasicAnnotationsTest {


    @RepeatedTest(3)
    public void testRepeated() {
        System.out.println("This is a repeated test");
    }


    @Test
    @Order(1)
    public void testOrder1() {
        System.out.println("This is test 1");
    }


    @Test
    @Order(2)
    public void testOrder2() {
        System.out.println("This is test 2");
    }



    @Test
    @DisplayName("This is a test with a display name")
    public void testDisplayName() {
        System.out.println("This is a test with a display name");
    }


    @Test
    @Tag("Sanity")
    public void testWithTag() {
        System.out.println("This is a test with a tag");
    }


    @Test
    @Tag("Sanity")
    @Tag("Regression")
    public void testWithMultipleTags() {
        System.out.println("This is a test with multiple tags");
    }


    @Test
    @Tag("Sanity")
    public void testWithRegressionTags() {
        System.out.println("This is a test with regression tags");
    }


    @Test
    @Timeout(1)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(800);
    }


    @Test
    @Disabled
    public void testDisabled() {
        System.out.println("This is a disabled test");
    }
}
