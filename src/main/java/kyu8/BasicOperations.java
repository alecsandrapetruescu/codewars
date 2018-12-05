package kyu8;

public class BasicOperations {
    public static Integer basicMath(String op, int v1, int v2)
    {
        Integer result = 0;
        switch (op) {
            case "+":
                result = v1 + v2;
                break;
            case "-":
                result = v1 - v2;
                break;
            case "*":
                result = v1 * v2;
                break;
            case "/":
                if (v2 == 0) throw new IllegalArgumentException("Division by 0!");
                result = v1 / v2;
                break;
            default:
                throw new IllegalArgumentException("Operation is unknown: " + op);
        }
        return result;
    }

}
