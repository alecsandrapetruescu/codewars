package kyu7;

public class MiddleCharacter {
    public static String getMiddle(String word) {
        int middle = Math.round(word.length() / 2);
        return word.length() % 2 == 0 ? word.substring(middle - 1, middle + 1) : word.substring(middle, middle + 1);
    }
}
