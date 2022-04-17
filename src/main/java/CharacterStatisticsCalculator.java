

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterStatisticsCalculator {

    private static final String LINE_SEPARATOR = ":";

    public IntSummaryStatistics compute(final Collection<String> source) {

        var lines = lines(source);
        var characters = characters(lines);

        return filter(characters)
                .map(ch -> (int) ch)
                .collect(Collectors.summarizingInt(c -> c));
    }

    private Stream<String> lines(Collection<String> source) {
        return source.stream() .map(string -> string.split(LINE_SEPARATOR)[1]);
    }

    private Stream<Character> characters(Stream<String> lines) {
        return lines.map(String::chars).flatMap(x -> x.mapToObj(c1 -> (char) c1));
    }

    private Stream<Character> filter(Stream<Character> characters) {
        return characters.map(Character::toLowerCase).filter(c1 -> c1 != ' ');
    }

}
