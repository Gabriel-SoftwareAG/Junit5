package ai.verisoft.lesson5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExternalParameterDemoTest {

    @Test
    @Tag("MyTag")
    public void externalParameterTest() {
        String parameter = System.getProperty("parameter");
        System.out.println("Parameter value: " + parameter);
        assertEquals("MyParameter", parameter);
    }
}
