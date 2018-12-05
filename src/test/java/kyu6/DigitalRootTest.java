package kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitalRootTest {

    @Test
    public void Tests() {
        assertEquals( "Nope!" , 7, DigitalRoot.digital_root(16));
        assertEquals( "Nope!" , 6, DigitalRoot.digital_root(456));
    }
}
