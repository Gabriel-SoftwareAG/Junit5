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

import org.junit.jupiter.api.*;

public class DependencyInjectionTests {

    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }


    @AfterEach
    public void after(TestReporter reporter) {
        reporter.publishEntry("a key", "a value");
    }


    @Test
    public void test1(TestReporter reporter) {
        reporter.publishEntry("a key", "a value");
        //System.out.println(testInfo.getDisplayName());
    }

    @Test
    @Tag("FastTest")
    @DisplayName("A very fast test")
    public void test2(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTestClass().toString());
        System.out.println(testInfo.getTestMethod().toString());
        System.out.println(testInfo.getTags().toString());

    }


    @RepeatedTest(3)
    public void test2(RepetitionInfo info) {
        System.out.println("This is repetition number " + info.getCurrentRepetition() + " out of "
                + info.getTotalRepetitions() + " repetitions");

        System.out.println("up till now there were " + info.getFailureCount() + " failed repetitions");

        Assertions.assertEquals(2, info.getCurrentRepetition());
    }
}
