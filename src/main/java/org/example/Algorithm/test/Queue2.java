package org.example.Algorithm.test;

import java.io.*;
import java.util.StringTokenizer;

public class Queue2 {

    private static final int FIRST = 0;

    static int[] queue;
    static int front = 0;
    static int back = 0;
    static int size = 0;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        queue = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push": push(Integer.parseInt(st.nextToken())); break;
                case "pop": pop(); break;
                case "size": size(); break;
                case "empty": empty(); break;
                case "front": front(); break;
                case "back": back(); break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int data) {
        queue[back] = data;
        back++;
        size++;
    }

    public static void pop() {
        if (size == 0) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue[front]).append("\n");
            size--;
            front++;
        }
    }

    public static void size() {
        sb.append(size).append("\n");
    }

    public static void empty() {
        if (size == 0) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    public static void front() {
        if (size == 0) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue[front]).append("\n");
        }
    }

    public static void back() {
        if (size == 0) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue[back - 1]).append("\n");
        }
    }
}
