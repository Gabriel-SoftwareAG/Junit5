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

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("MyTag")
public class AnnotationsTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("In the before all tests");
    }


    @BeforeEach
    public void beforeEach() {
        System.out.println("In the before each test");
    }


    @AfterEach
    public void afterEach() {
        System.out.println("In the after each test");
    }


    @AfterAll
    public static void afterAll() {
        System.out.println("In the after all tests");
    }


    @Test
    public void ThisTestWillPass() {
        System.out.println("This test will pass");
        Assertions.assertTrue(true);
    }


    @Test
    public void test2() {
        System.out.println("This test will fail");
        assertEquals(1, 2);
    }
}
