package org.example.Algorithm.test;

import java.text.DecimalFormat;
import java.util.*;

public class PostfixExpression2 {

    private static final String MULTIPLICATION = "*";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVISION = "/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // ABC*+DE/- -> (A+(B*C))-(D/E)
        Double value = result(N, sc);

        String result = String.format("%.2f", value);
        System.out.println(result);
        sc.close();
    }

    private static Double result(int N, Scanner sc) {
        String postExpression = sc.next();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(sc.nextInt());
        }

        Map<String, Double> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < postExpression.length(); i++) {
            char c = postExpression.charAt(i);
            String s = String.valueOf(c);

            if (!Character.isLetter(c)) {
                Double y = stack.pop();
                Double x = stack.pop();

                Double result = calculation(s, x, y);
                stack.add(result);
            } else {
                Double findValue = map.get(s);
                if (findValue == null) {
                    Double v = Double.valueOf(q.remove());
                    map.put(s, v);
                    stack.add(v);
                } else {
                    stack.add(findValue);
                }
            }
        }
        map.clear();

        return stack.pop();
    }

    private static Double calculation(String operator, double x, double y) {

        if (PLUS.equals(operator)) {
            return x + y;
        } else if (MINUS.equals(operator)) {
            return x - y;
        } else if (MULTIPLICATION.equals(operator)) {
            return x * y;
        } else if (DIVISION.equals(operator)) {
            return x / y;
        } else {
            return null;
        }
    }
}
