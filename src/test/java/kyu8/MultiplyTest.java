package kyu8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MultiplyTest {
    @Test
    public void testSomething() {
        assertEquals(java.util.Optional.of(2.00).get(), Multiply.multiply(1.00, 2.00));
    }
}