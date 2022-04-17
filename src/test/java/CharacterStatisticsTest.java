import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterStatisticsTest {

    final List<String> source = List.of(
            "line 1: Without deviation from the norm, progress is not possible.",
            "line 2: A mind is like a parachute. It doesn’t work if it is not open.",
            "line 3: The last line"
    );

    final CharacterStatisticsCalculator characterStatistics = new CharacterStatisticsCalculator();
    final IntSummaryStatistics summaryStatistics = characterStatistics.compute(source);

    @Test
    void testMin() {
        assertEquals(',', summaryStatistics.getMin());
    }

    @Test
    void testMax() {
        assertEquals('’', summaryStatistics.getMax());
    }

    @Test
    void testCount() {
        assertEquals(110, summaryStatistics.getCount());
    }

    @Test
    void testAvg() {
        assertEquals(180, Math.round(summaryStatistics.getAverage()));
    }

    @Test
    void testSum() {
        assertEquals(19799, Math.round(summaryStatistics.getSum()));
    }
}