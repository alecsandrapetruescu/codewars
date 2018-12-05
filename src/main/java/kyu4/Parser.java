package kyu4;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static int parseInt(String numStr) {
        Map<String, Integer> numbers = getNumberMap();
        Map<String, Integer> multiple = getMultiplyMap();
        String[] numbersArr = numStr.replace(" and ", " ").split("\\s+|-");
        int result = 0;
        if (numbersArr.length < 0) return -1;
        for (int i=0; i <= numbersArr.length-1 ; i++) {
            if (i == numbersArr.length-1) {
                if (multiple.containsKey(numbersArr[i])) {
                    result *= multiple.get(numbersArr[i]);
                } else {
                    result += numbers.get(numbersArr[i]);
                }
                continue;
            }
            if (numbersArr.length > 1 && multiple.containsKey(numbersArr[i + 1])) {
                if (numbersArr[i + 1].equals("thousand")) {
                    result += numbers.get(numbersArr[i]);
                    result *= multiple.get(numbersArr[i + 1]);
                } else {
                    result += numbers.get(numbersArr[i]) * multiple.get(numbersArr[i + 1]);
                }
                i++;
            } else {
                if (multiple.containsKey(numbersArr[i])) {
                    result *= multiple.get(numbersArr[i]);
                } else {
                    result += numbers.get(numbersArr[i]);
                }
            }
        }
        return result;
    }

    private static Map<String, Integer> getMultiplyMap() {
        Map<String, Integer> multiple = new HashMap<>() ;
        multiple.put("hundred", 100);
        multiple.put("thousand", 1000);
        multiple.put("million", 1000000);
        return multiple;
    }

    private static Map<String, Integer> getNumberMap() {
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);
        numbers.put("eleven", 11);
        numbers.put("twelve", 12);
        numbers.put("thirteen", 13);
        numbers.put("fourteen", 14);
        numbers.put("fifteen", 15);
        numbers.put("sixteen", 16);
        numbers.put("seventeen", 17);
        numbers.put("eighteen", 18);
        numbers.put("nineteen", 19);
        numbers.put("twenty", 20);
        numbers.put("thirty", 30);
        numbers.put("forty", 40);
        numbers.put("fifty", 50);
        numbers.put("sixty", 60);
        numbers.put("seventy", 70);
        numbers.put("eighty", 80);
        numbers.put("ninety", 90);
        return numbers;
    }
}
