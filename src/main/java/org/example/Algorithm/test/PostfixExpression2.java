package org.example.Algorithm.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PostfixExpression2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String operands = operandMapper(N, sc);

        System.out.println(operands);
        sc.close();
    }

    private static String operandMapper(int N, Scanner sc) {
        String postExpression = sc.next();

        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String operand = sc.next();
            q.add(operand);
        }

        int length = postExpression.length();
        String[] operandArray = new String[length];
        for (int i = 0; i < operandArray.length; i++) {
            char c = postExpression.charAt(i);
            if (Character.isLetter(c)) {
                operandArray[i] = q.poll();
            } else {
                operandArray[i] = String.valueOf(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : operandArray) {
            sb.append(s);
        }

        return sb.toString();
    }
}
