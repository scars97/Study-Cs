package org.example.Algorithm.test;

import java.util.*;

public class ParenthesisString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println(compare(sc.next()));
        }
    }

    public static String compare(String input) {
        Stack<String> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            String ps = String.valueOf(c);

            if ("(".equals(ps)) {
                stack.push(ps);
            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        return stack.empty() ? "YES" : "NO";
    }
}
