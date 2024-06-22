package ai.verisoft;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.OS.*;

public class ConditionalTests {

    @Test
    @EnabledOnOs(WINDOWS)
    void onlyOnWindowsOs() {
        System.out.println("This test will only run on Windows");
    }

    @Test
    @EnabledOnOs({ LINUX, MAC })
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
        return true;
    }
}
