package org.example.Algorithm.test;

import java.security.Key;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yosepus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        sb.append("<");
        while (!q.isEmpty()) {
            int result;
            for (int i = 0; i < K; i++) {
                if (i == K - 1) {
                    result = q.poll();
                    if (q.isEmpty()) {
                        sb.append(result).append(">");
                    } else {
                        sb.append(result).append(", ");
                    }
                } else {
                    int poll = q.poll();
                    q.add(poll);
                }
            }
        }
        System.out.println(sb);
    }
}
