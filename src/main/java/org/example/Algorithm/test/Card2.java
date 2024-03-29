package org.example.Algorithm.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }

        while (q.size() > 1) {
            q.poll();
            int poll = q.poll();
            q.add(poll);
        }

        System.out.println(q.peek());
    }
}
