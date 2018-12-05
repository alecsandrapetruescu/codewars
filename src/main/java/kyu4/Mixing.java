package kyu4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Mixing {
    public static String mix(String s1, String s2) {
        return IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> Search.search((char) c, s1, s2))
                .filter(Search::isValid)
                .sorted()
                .map(Search::toString)
                .collect(Collectors.joining("/"));
    }
}

class Search implements Comparable<Search> {
    private final int source;
    private final char character;
    private final long count;
    private final String result;

    private Search(int source, char character, long count) {
        this.source = source;
        this.character = character;
        this.count = count;
        result = build();
    }

    static Search search(char character, String firstString, String secondString) {
        long countFirst = firstString.chars().filter(ch -> ch == character).count();
        long countSecond = secondString.chars().filter(ch -> ch == character).count();
        return countFirst == countSecond ? new Search(0, character, countFirst)
                : countFirst > countSecond ? new Search(1, character, countFirst)
                : new Search(2, character, countSecond);
    }

    boolean isValid() {
        return count > 1;
    }

    private String build() {
        String src = source == 0 ? "=" : String.valueOf(source);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
        return String.format("%s:%s", src, sb);
    }

    @Override
    public int compareTo(Search o) {
        int byCount = Long.compare(o.count, count);
        if (byCount != 0) {
            return byCount;
        }
        return result.compareTo(o.result);
    }

    @Override
    public String toString() {
        return result;
    }
}
