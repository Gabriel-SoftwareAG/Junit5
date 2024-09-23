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

import ai.verisoft.Calculator;
import ai.verisoft.Person;
import ai.verisoft.lesson1.NumericalUtilities;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

class AssertionsDemoTest {

    private final Calculator calculator = new Calculator();

    private final Person person = new Person("Jane", "Doe");

    @Test
    public void stoppedAssertion() {
        int num1 = 3, num2 = 5;

        assertAll("Assert all functinos",
                () -> assertEquals(8, calculator.add(num1, num2)),
                () -> assertEquals(15, calculator.multiply(num1, num2))
        );
    }

    @Test
    void standardAssertions() {
        boolean isUserDefines = false;
        assertAll("test all",
                () -> assertTrue(isUserDefines, "The user is not defined"),
                () -> assertEquals(3, 1 + 1)
        );


//        assertEquals(4, calculator.multiply(2, 2),
//                "The optional failure message is now the last parameter");
//
//        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
//                + "to avoid constructing complex messages unnecessarily.");
    }

    @Test
    void assertionsTest() {
        assertNotEquals(3, calculator.add(1, 1), () -> "The optional failure message is now the last parameter");
        assertTrue(NumericalUtilities.isEven(2), "2 is even");
        assertFalse(NumericalUtilities.isEven(3), "3 is not even");
        assertNull(null, "null is null");
        assertNotNull("not null", "not null is not null");

        // Objects
        Person person1 = new Person("Jane", "Doe");
        Person person2 = new Person("Jane", "Doe");
        assertSame(person1, person1, "Jane Doe is Jane Doe");
        assertNotSame(person1, person2, "Jane Doe 1 is not Jane Doe 2");

        // Arrays
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        assertArrayEquals(array1, array2, "Arrays are equal");

        // Strings
        String string1 = "Jane";
        String string2 = "Jane";
        assertLinesMatch(string1.lines(), string2.lines(), "Strings are equal");
    }


    @Test
    void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("person",
                () -> assertEquals("Jane", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName())
        );
    }


    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }


    @Test
    void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMillis(500), () -> {
            // Perform task that takes less than 2 minutes.
            Thread.sleep(300);
            assertTrue(true);
            Thread.sleep(300);
        });
    }


    @Test
    void timeoutNotExceededWithResult() {
        // The following assertion succeeds, and returns the supplied object.
        String actualResult = assertTimeout(ofMinutes(2), () -> {
            return "a result";
        });
        assertEquals("a result", actualResult);
    }


    @Test
    void timeoutNotExceededWithMethod() {
        // The following assertion invokes a method reference and returns an object.
        String actualGreeting = assertTimeout(ofMinutes(2), AssertionsDemoTest::greeting);
        assertEquals("Hello, World!", actualGreeting);
    }


    @Test
    void timeoutExceeded() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100);
        });
    }


    @Test
    void timeoutExceededWithPreemptiveTermination() {
        // The following assertion fails with an error message similar to:
        // execution timed out after 10 ms
        assertTimeoutPreemptively(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            new CountDownLatch(1).await();
        });
    }


    @Test
    void failedTest() {
        fail("disabled until bug #33 is fixed");
        // Test scnario
        // .....
        // Some more code
    }


    @Test
    void dependentAssertions() {
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("e"))
                    );
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of first name assertions.
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    // Executed only if the previous assertion is valid.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }


    private static String greeting() {
        return "Hello, World!";
    }
}
