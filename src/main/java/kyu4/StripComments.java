package kyu4;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        String symbols = String.format("[ ]*([%s].*)?$", String.join("", commentSymbols));
        return Stream.of(text.split("\n")).map(t -> t.replaceAll(symbols, "")).collect(Collectors.joining("\n"));
    }
}
