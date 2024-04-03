package org.example.Algorithm.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PostfixExpression2 {

    private static final String MULTIPLICATION = "*";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVISION = "/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // ABC*+DE/- -> (A+(B*C))-(D/E)
        Double result = result(N, sc);

        System.out.println(result);
        sc.close();
    }

    private static Double result(int N, Scanner sc) {
        String postExpression = sc.next();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(sc.nextInt());
        }

        Stack<Double> stack = new Stack<>();
        //ABC*+DE/-
        for (int i = 0; i < postExpression.length(); i++) {
            char c = postExpression.charAt(i);
            if (!Character.isLetter(c)) {
                String operator = String.valueOf(c);
                Double y = stack.pop();
                Double x = stack.pop();

                Double result = calculation(operator, x, y);
                stack.add(result);
            } else {
                Double v = Double.valueOf(q.remove());
                stack.add(v);
            }
        }

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
