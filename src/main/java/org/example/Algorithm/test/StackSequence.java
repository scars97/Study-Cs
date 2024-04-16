package org.example.Algorithm.test;

import java.util.*;

public class StackSequence {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String IMPOSSIBLE = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input.add(sc.nextInt());
        }

        // 4 3 6 8 7 5 2 1
        // 1 2 5 3 4
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 1; i <= N; i++) {
            if (i == input.get(index)) {
                stack.push(i);
                sb.append(PLUS).append("\n");

                int last = stack.pop();
                sb.append(MINUS).append("\n");

                index++;

                for (int j = index; j < N; j++) {
                    if (input.get(index) == last - 1) {
                        last = stack.pop();
                        sb.append(MINUS).append("\n");

                        index++;
                    } else {
                        break;
                    }
                }
            } else {
                stack.push(i);
                sb.append(PLUS).append("\n");
            }
        }

        for (int i = index + 1; i < N; i++) {
            if (input.get(i) >= input.get(i - 1)) {
                sb.setLength(0);
                stack.clear();

                sb.append(IMPOSSIBLE);
                break;
            }
        }

        while (!stack.isEmpty()) {
            stack.pop();
            sb.append(MINUS).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
