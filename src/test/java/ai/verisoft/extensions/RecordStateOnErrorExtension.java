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

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.LifecycleMethodExecutionExceptionHandler;

public class RecordStateOnErrorExtension implements LifecycleMethodExecutionExceptionHandler {
    @Override
    public void handleBeforeAllMethodExecutionException(ExtensionContext context, Throwable ex)
            throws Throwable {
        memoryDumpForFurtherInvestigation("Failure recorded during class setup");
        throw ex;
    }


    @Override
    public void handleBeforeEachMethodExecutionException(ExtensionContext context, Throwable ex)
            throws Throwable {
        memoryDumpForFurtherInvestigation("Failure recorded during test setup");
        throw ex;
    }


    @Override
    public void handleAfterEachMethodExecutionException(ExtensionContext context, Throwable ex)
            throws Throwable {
        memoryDumpForFurtherInvestigation("Failure recorded during test cleanup");
        throw ex;
    }


    @Override
    public void handleAfterAllMethodExecutionException(ExtensionContext context, Throwable ex)
            throws Throwable {
        memoryDumpForFurtherInvestigation("Failure recorded during class cleanup");
        throw ex;
    }


    private void memoryDumpForFurtherInvestigation(String failureRecordedDuringClassSetup) {
        System.out.println("This is a memory dump mock " + failureRecordedDuringClassSetup);
    }
}
