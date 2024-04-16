package org.example.Algorithm.test;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.*;

public class StackSequence {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String IMPOSSIBLE = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 4 3 6 8 7 5 2 1
        // 1 2 5 3 4
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();

            if (value > index) {
                for (int j = index + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append(PLUS).append("\n");
                }
                index = value;
            } else if (stack.peek() != value) {
                sb.setLength(0);
                sb.append(IMPOSSIBLE);
                break;
            }

            stack.pop();
            sb.append(MINUS).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
