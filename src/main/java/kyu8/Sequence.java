package kyu8;

import java.util.stream.IntStream;

public class Sequence {
    public static int[] reverse(int n){
        return IntStream.rangeClosed(0, n-1).map(i -> n-i).toArray();
    }
}
