package org.example.Algorithm.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<");
        while (q.size() > 1) {

            for (int i = 0; i < K - 1; i++) {
                int poll = q.poll();
                q.offer(poll);
            }

            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}
