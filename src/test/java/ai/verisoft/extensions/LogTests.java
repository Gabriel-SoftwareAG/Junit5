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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.fail;

public class LogTests {

    public LogTests() {
        System.out.println("This is constructor");
    }

    @BeforeEach
    public void setup() {
        System.out.println("This is before each");
    }

    @Test
    @Tag("slow")
    @ExtendWith(LogExtension.class)
    public void test1() {
        System.out.println("This is test #1");
        fail("This test has failed because of reasons");
    }

    @Test
    public void test2() {
        System.out.println("This is test #2");
    }
}
