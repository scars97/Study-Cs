package org.example.Algorithm.test;

import java.util.*;

public class ParenthesisString {

    private static final String LPS = "(";
    private static final String RPS = ")";
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Queue<String> psList = new LinkedList<>();

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String input = sc.next();

            String result = compare(input, psList);
            sb.append(result).append("\n");
        }
        sc.close();
        System.out.println(sb);
    }

    public static String compare(String input, Queue<String> psList) {
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            String[] ps = input.split("");

            if (RPS.equals(ps[0])) {
                return NO;
            } else {
                if (LPS.equals(ps[i])) {
                    psList.add(ps[i]);
                }
            }

            if (RPS.equals(ps[i])) {
                if (psList.peek() != null) {
                    psList.remove();
                } else {
                    return NO;
                }
            }
        }

        result = psList.isEmpty() ? YES : NO;
        psList.clear();

        return result;
    }
}
