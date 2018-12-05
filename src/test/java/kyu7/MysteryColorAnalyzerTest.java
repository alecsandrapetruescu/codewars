package kyu7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MysteryColorAnalyzerTest {
    @Test
    public void testSomething() {
        MysteryColorAnalyzer analyzer = new MysteryColorAnalyzerImpl();
        List<Color> mysteryColors = new ArrayList<>();
        mysteryColors.add(Color.BLUE);
        mysteryColors.add(Color.RED);
        mysteryColors.add(Color.GREEN);
        mysteryColors.add(Color.GREEN);
        assertEquals(3, analyzer.numberOfDistinctColors(mysteryColors));

        assertEquals(2, analyzer.colorOccurrence(mysteryColors, Color.GREEN));
    }
}
