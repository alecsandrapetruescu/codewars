package kyu7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VowelsTest {
    @Test
    public void testCase1() {
        assertEquals("Nope!", 5, Vowels.getCount("abracadabra"));
        assertEquals("Nope!", 5, Vowels.getCount("is it a bear?"));
    }
}
