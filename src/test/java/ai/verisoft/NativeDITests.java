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

import org.junit.jupiter.api.*;

public class NativeDITests {

    public NativeDITests(TestInfo info) {
        System.out.println("Constructor: " + info.getDisplayName());

    }


    @Tag("TestInfoTest")
    @DisplayName("Test info DI Test")
    @Test
    public void TestInfoDITest(TestInfo info) {
        System.out.println("Tags: " + info.getTags());
        System.out.println("Test class: " + info.getTestClass());
        System.out.println("Test method: " + info.getTestMethod());
    }


    @RepeatedTest(3)
    public void RepetitionDITest(RepetitionInfo info) {
        System.out.println("Current repetition: " + info.getCurrentRepetition());
        System.out.println("Total repetitions: " + info.getTotalRepetitions());
        System.out.println("Failure count: " + info.getFailureCount());
    }


    @AfterEach
    public void afterEach(TestReporter reporter) {
        reporter.publishEntry("after", "report");
    }
}
