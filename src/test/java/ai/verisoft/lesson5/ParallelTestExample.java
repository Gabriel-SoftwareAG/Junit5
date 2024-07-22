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
package ai.verisoft.lesson5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@Execution(ExecutionMode.CONCURRENT)
public class ParallelTestExample {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    public void test1(int x) throws InterruptedException {
        System.out.println("test #1 " + x);
        Thread.sleep(5000);
    }


    @Test
    public void test2() throws InterruptedException {
        System.out.println("test #2");
        Thread.sleep(3000);
    }
}
