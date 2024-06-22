package ai.verisoft;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;


@Execution(ExecutionMode.CONCURRENT)
public class ParallelTestExample {

    @Test
    public void test1() throws InterruptedException {
        System.out.println("test #1");
        Thread.sleep(1000);
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("test #2");
        Thread.sleep(400);
    }
}
