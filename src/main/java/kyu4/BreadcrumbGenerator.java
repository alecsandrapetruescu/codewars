package kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BreadcrumbGenerator {
    private static final String HREF = "<a href=\"#LINK#\">#LINK_TEXT#</a>";
    private static final String SPAN = "<span class=\"active\">#SPAN_TEXT#</span>";
    private static final List<String> IGNORE = new ArrayList<>(Arrays.asList("the", "of", "in", "from", "by", "with", "and", "or", "for", "to", "at", "a"));

    public static String generate_bc(String url, String separator) {
        url = url.substring(url.indexOf("."));
        url = url.substring(url.indexOf("/") + 1).split("\\?|#|index\\.")[0];

        if (url.trim().equals("") || !url.contains("/")) return SPAN.replaceAll("#SPAN_TEXT#", "HOME");
        if (url.endsWith("/")) url = url.substring(0, url.length() - 1);

        String home = HREF.replaceAll("#LINK#", "/").replaceAll("#LINK_TEXT#", "HOME") + separator;
        String[] urlParts = url.split("/");
        String span = SPAN.replaceAll("#SPAN_TEXT#", parse(urlParts[urlParts.length - 1].split("\\.")[0]));
        urlParts = Arrays.copyOf(urlParts, urlParts.length - 1);
        if (urlParts.length == 0) return home + span;
        String href = "";
        StringBuilder builder = new StringBuilder();
        builder.append(home);
        for (int i = 0; i < urlParts.length; i++) {
            StringBuilder link = new StringBuilder();
            for (int j = 0; j <= i; j++) link.append(urlParts[j]).append("/");
            String linkText = parse(urlParts[i]);
            href = HREF
                    .replaceAll("#LINK#", "/" + link)
                    .replaceAll("#LINK_TEXT#", linkText) + separator;
            builder.append(href);
        }
        builder.append(span);
        return builder.toString();
    }

    private static String parse(String text) {
        return (text.length() >= 30 ?
                Arrays.stream(text.replace("/", "").split("-"))
                        .filter(s -> IGNORE.stream().noneMatch(s::equals))
                        .map(s -> "" + s.charAt(0))
                        .collect(Collectors.joining())
                : text.replace("-", " ")).toUpperCase();
    }
}
