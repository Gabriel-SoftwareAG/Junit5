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

import java.lang.reflect.Field;
import java.util.function.Predicate;

import ai.verisoft.Random;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.support.ModifierSupport;

import static org.junit.platform.commons.util.AnnotationUtils.findAnnotatedFields;

public class RandomNumberExtension implements BeforeAllCallback, BeforeEachCallback, ParameterResolver {
    private final java.util.Random random = new java.util.Random(System.nanoTime());

    /**
     * Inject a random integer into static fields that are annotated with
     * {@code @Random} and can be assigned an integer value.
     */
    @Override
    public void beforeAll(ExtensionContext context) {
        Class<?> testClass = context.getRequiredTestClass();
        injectFields(testClass, null, ModifierSupport::isStatic);
    }


    /**
     * Inject a random integer into non-static fields that are annotated with
     * {@code @Random} and can be assigned an integer value.
     */
    @Override
    public void beforeEach(ExtensionContext context) {
        Class<?> testClass = context.getRequiredTestClass();
        Object testInstance = context.getRequiredTestInstance();
        injectFields(testClass, testInstance, ModifierSupport::isNotStatic);
    }


    /**
     * Determine if the parameter is annotated with {@code @Random} and can be
     * assigned an integer value.
     */
    @Override
    public boolean supportsParameter(ParameterContext pc, ExtensionContext ec) {
        return pc.isAnnotated(Random.class) && isInteger(pc.getParameter().getType());
    }


    /**
     * Resolve a random integer.
     */
    @Override
    public Integer resolveParameter(ParameterContext pc, ExtensionContext ec) {
        return this.random.nextInt();
    }


    private void injectFields(Class<?> testClass, Object testInstance,
                              Predicate<Field> predicate) {

        predicate = predicate.and(field -> isInteger(field.getType()));
        findAnnotatedFields(testClass, Random.class, predicate)
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        field.set(testInstance, this.random.nextInt());
                    }
                    catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                });
    }


    private static boolean isInteger(Class<?> type) {
        return type == Integer.class || type == int.class;
    }
}
