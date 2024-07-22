package ai.verisoft.lesson4;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MetaAnnotationDemoTest {

    @FastTest
    public void testFast() {
        System.out.println("This is a fast test");
    }



}
