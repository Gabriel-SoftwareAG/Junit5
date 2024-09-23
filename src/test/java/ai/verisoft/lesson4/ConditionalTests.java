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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.OS.*;

public class ConditionalTests {

    @Test
    @EnabledOnOs(WINDOWS)
    void onlyOnWindowsOs() {
        System.out.println("This test will only run on Windows");
    }


    @Test
    @EnabledOnOs({LINUX, MAC})
    void onLinuxOrMac() {
        System.out.println("This test will run on Linux or macOS");
    }


    @Test
    @DisabledOnOs(WINDOWS)
    void notOnWindows() {
        System.out.println("This test will not run on Windows");
    }


    @Test
    @EnabledOnOs(architectures = "aarch64")
    void onAarch64() {
        System.out.println("This test will run on aarch64");
    }


    @Test
    @DisabledOnOs(architectures = "x86_64")
    void notOnX86_64() {
        System.out.println("This test will not run on x86_64");
    }


    @Test
    @EnabledOnOs(value = MAC, architectures = "aarch64")
    void onNewMacs() {
        System.out.println("This test will run on new Macs");
    }


    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void onlyOn64BitArchitectures() {
        System.out.println("This test will only run on 64-bit architectures");
    }

    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "CI")
    void onlyOnCITest() {
        System.out.println("This test will only run on CI");
    }


    @Test
    @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    void notOnCiServer() {
        System.out.println("This test will not run on the CI server");
    }


    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    void onlyOnStagingServer() {
        System.out.println("This test will only run on the staging server");
    }


    @Test
    @EnabledIf("customCondition")
    void enabled() {
        System.out.println("This test is custom condition - enabled");
    }


    @Test
    @DisabledIf("customCondition")
    void disabled() {
        System.out.println("This test is custom condition - disabled");
    }


    boolean customCondition() {
        return false;
    }
}
