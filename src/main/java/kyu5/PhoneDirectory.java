package kyu5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneDirectory {
    public static  String phone(String strng, String num) {
        String[] details = strng.split("\n");
        List<String> numbers = Arrays.stream(details).filter(w -> w.indexOf("+" + num) != -1).collect(Collectors.toList());
        int numberOfTimesFound = numbers.size();
        if (numberOfTimesFound == 0) return String.format("Error => Not found: %s", num);
        if (numberOfTimesFound > 1) return String.format("Error => Too many people: %s", num);
        String name = numbers.get(0).replaceAll("(.*)<(.*)>(.*)", "$2");
        String address = numbers.get(0)
                .replaceAll(";|\\+|!|,|/|\\$|\\:|\\*|\\?", "")
                .replaceAll(num, "")
                .replaceAll("<(.*)>(.*)", "$2")
                .replaceAll("_|\\s+", " ")
                .trim();

        return String.format("Phone => %s, Name => %s, Address => %s",
                num,
                name,
                address);
    }
}
