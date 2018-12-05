package kyu6;

public class DigitalRoot {
    public static int digital_root(int n) {
        int sum = sum(n);
        if (sum / 10 != 0) sum = sum(sum);
        return sum;
    }

    private static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
