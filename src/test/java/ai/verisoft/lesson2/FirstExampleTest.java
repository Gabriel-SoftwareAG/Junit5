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
package ai.verisoft.lesson2;

import ai.verisoft.lesson1.NumericalUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstExampleTest {

    @Test
    public void testDivide() {
        int result = NumericalUtilities.divide(10, 2);
        Assertions.assertEquals(4, result);
    }


    @Test
    public void testDivideRevised() {
        double result = divide(9, 4.5);
        Assertions.assertEquals(2, result, "9 divided by 4.5 must be 2");
    }


    public static <T extends Number> double divide(T numerator, T denominator) throws IllegalArgumentException {
        if (denominator.doubleValue() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return numerator.doubleValue() / denominator.doubleValue();
    }
}
