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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParameterizationTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void palindromes(int candidate) {
        Assertions.assertEquals(candidate, 2);
    }


    @ParameterizedTest
    @ValueSource(strings = { "alpha", "beta", "charly" })
    void palindromes(String candidate) {
        Assertions.assertEquals(candidate.length(), 5);
    }


    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    void testWithEnumSource(TemporalUnit unit) {
        assertNotNull(unit);
    }


    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument) {
        assertNotNull(argument);
    }


    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana", "charly");
    }


    @ParameterizedTest
    @MethodSource("range")
    void testWithRangeMethodSource(int argument) {
        assertNotEquals(9, argument);
    }


    static IntStream range() {
        return IntStream.range(0, 20).skip(10);
    }


    @ParameterizedTest(name = "#{index} - Run test with argument={0}")
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        assertEquals(5, str.length());
        assertTrue(num >=1 && num <=2);
        assertEquals(2, list.size());
    }


    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("apple", 1, Arrays.asList("a", "b")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }


    @ParameterizedTest
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 0xF1",
            "strawberry,    700_000"
    })
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }


    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void testWithArgumentsSource(String argument) {
        assertNotNull(argument);
    }
}
