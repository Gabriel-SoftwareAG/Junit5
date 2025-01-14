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

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.*;

@Slf4j
public class LogExtension implements BeforeAllCallback,
        BeforeTestExecutionCallback, BeforeEachCallback, AfterTestExecutionCallback {
    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        String msg = "Extension - Starting test";
        log.info(msg);
        System.out.println(msg);
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        String msg = "Extension - Finished test";
        log.info(msg);
        System.out.println(msg);
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        String msg = "Extension - Before all";
        log.info(msg);
        System.out.println(msg);
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        String msg = "Extension - Before each";
        log.info(msg);
        System.out.println(msg);
    }
}
