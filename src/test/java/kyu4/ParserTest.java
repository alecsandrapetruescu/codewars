package kyu4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void fixedTests() {
        assertEquals(1 , Parser.parseInt("one"));
        assertEquals(20 , Parser.parseInt("twenty"));
        assertEquals(246 , Parser.parseInt("two hundred forty-six"));
        assertEquals(246000 , Parser.parseInt("two hundred forty-six thousand"));
        assertEquals(246001 , Parser.parseInt("two hundred forty-six thousand and one"));
    }
}
