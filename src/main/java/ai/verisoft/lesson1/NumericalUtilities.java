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
package ai.verisoft.lesson1;

/**
 * A bunch of numerical utilities, for use during the course.
 *
 * @author Nir Gallner
 */
public class NumericalUtilities {

    public static int add(int a, int b) {
        return a + b;
    }


    public static int subtract(int a, int b) {
        return a - b;
    }


    public static int multiply(int a, int b) {
        return a * b;
    }


    public static int divide(int a, int b) {
        return a / b;
    }


    public static int modulo(int a, int b) {
        return a % b;
    }


    public static boolean isEven(int a) {
        return a % 2 == 0;
    }


    public static boolean isOdd(int a) {
        return a % 2 != 0;
    }


    public static boolean isPrime(int a) {
        if (a < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static int factorial(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        int result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }


    public static int fibonacci(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Fibonacci is not defined for negative numbers");
        }
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= a; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }


    public static int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("GCD is not defined for negative numbers");
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    public static int lcm(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("LCM is not defined for negative numbers");
        }
        return a * b / gcd(a, b);
    }


    public static int power(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Power is not defined for negative exponents");
        }
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }


    public static int sqrt(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Square root is not defined for negative numbers");
        }
        int result = 0;
        while (result * result <= a) {
            result++;
        }
        return result - 1;
    }


    public static int log(int a, int b) {
        if (a < 0 || b < 0 || b == 1) {
            throw new IllegalArgumentException("Logarithm is not defined for negative numbers or base 1");
        }
        int result = 0;
        while (a >= b) {
            a /= b;
            result++;
        }
        return result;
    }


    public static int abs(int a) {
        return a < 0 ? -a : a;
    }


    public static int max(int a, int b) {
        return a > b ? a : b;
    }


    public static int min(int a, int b) {
        return Math.min(a, b);
    }


    public static int sum(int[] a) {
        int result = 0;
        for (int j : a) {
            result += j;
        }
        return result;
    }


    public static int product(int[] a) {
        int result = 1;
        for (int j : a) {
            result *= j;
        }
        return result;
    }


    public static int max(int[] a) {
        int result = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > result) {
                result = a[i];
            }
        }
        return result;
    }


    public static int min(int[] a) {
        int result = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < result) {
                result = a[i];
            }
        }
        return result;
    }


    public static int[] sort(int[] a) {
        int[] result = new int[a.length];
        System.arraycopy(a, 0, result, 0, a.length);
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] < result[i]) {
                    int temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        return result;
    }


    public static int[] reverse(int[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - 1 - i];
        }
        return result;
    }


    public static int[] copy(int[] a) {
        int[] result = new int[a.length];
        System.arraycopy(a, 0, result, 0, a.length);
        return result;
    }


    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }


    public static int[] slice(int[] a, int start, int end) {
        if (start < 0 || start >= a.length || end < 0 || end > a.length || start >= end) {
            throw new IllegalArgumentException("Invalid start or end index");
        }
        int[] result = new int[end - start];
        System.arraycopy(a, start, result, 0, end - start);
        return result;
    }


    public static int[] filter(int[] a, int value) {
        int count = 0;
        for (int j : a) {
            if (j == value) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int j : a) {
            if (j == value) {
                result[index] = j;
                index++;
            }
        }
        return result;
    }


    public static int[] map(int[] a, int value) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * value;
        }
        return result;
    }


    public static int[] reduce(int[] a, int value) {
        int result = value;
        for (int j : a) {
            result += j;
        }
        return new int[]{result};
    }


    public static int[] rotate(int[] a, int value) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[(i + value) % a.length] = a[i];
        }
        return result;
    }


    public static int[] shuffle(int[] a) {
        int[] result = new int[a.length];
        System.arraycopy(a, 0, result, 0, a.length);
        for (int i = 0; i < result.length; i++) {
            int j = (int) (Math.random() * result.length);
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }
        return result;
    }


    public static int[] reverse(int[] a, int start, int end) {
        if (start < 0 || start >= a.length || end < 0 || end > a.length || start >= end) {
            throw new IllegalArgumentException("Invalid start or end index");
        }
        int[] result = new int[a.length];
        System.arraycopy(a, 0, result, 0, a.length);
        for (int i = start; i < end; i++) {
            result[i] = a[end - 1 - i];
        }
        return result;
    }


    public static int[] copy(int[] a, int start, int end) {
        if (start < 0 || start >= a.length || end < 0 || end > a.length || start >= end) {
            throw new IllegalArgumentException("Invalid start or end index");
        }
        int[] result = new int[end - start];
        System.arraycopy(a, start, result, start - start, end - start);
        return result;
    }


    public static int[] merge(int[] a, int[] b, int start, int end) {
        if (start < 0 || start >= a.length || end < 0 || end > a.length || start >= end) {
            throw new IllegalArgumentException("Invalid start or end index");
        }
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, start);
        System.arraycopy(b, 0, result, start, b.length);
        System.arraycopy(a, end, result, b.length + end, a.length - end);
        return result;
    }


    public static int[] slice(int[] a, int start, int end, int step) {
        if (start < 0 || start >= a.length || end < 0 || end > a.length || start >= end || step <= 0) {
            throw new IllegalArgumentException("Invalid start, end or step index");
        }
        int count = 0;
        for (int i = start; i < end; i += step) {
            count++;
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = start; i < end; i += step) {
            result[index] = a[i];
            index++;
        }
        return result;
    }


    public static int[] filter(int[] a, int value, int start, int end) {
        if (start < 0 || start >= a.length || end < 0 || end > a.length || start >= end) {
            throw new IllegalArgumentException("Invalid start or end index");
        }
        int count = 0;
        for (int i = start; i < end; i++) {
            if (a[i] == value) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = start; i < end; i++) {
            if (a[i] == value) {
                result[index] = a[i];
                index++;
            }
        }
        return result;
    }


    public static int[] map(int[] a, int value, int start, int end) {
        if (start < 0 || start >= a.length || end < 0 || end > a.length || start >= end) {
            throw new IllegalArgumentException("Invalid start or end index");
        }
        int[] result = new int[a.length];
        System.arraycopy(a, 0, result, 0, a.length);
        for (int i = start; i < end; i++) {
            result[i] = a[i] * value;
        }
        return result;
    }
}
