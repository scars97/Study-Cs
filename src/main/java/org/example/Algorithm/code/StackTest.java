package org.example.Algorithm.code;

import java.util.Scanner;

public class StackTest {
    private static int[] stack;
    private static int SIZE = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        stack = new int[N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            switch (str) {
                case "push":
                    push(sc.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }

        }
        System.out.println(sb);
    }

    public static void push(int data) {
        stack[SIZE] = data;
        SIZE++;
    }

    public static int pop() {
        if (SIZE == 0) {
            return -1;
        }
        int topIndex = SIZE - 1;
        int popElement = stack[topIndex];
        stack[topIndex] = 0;

        SIZE--;
        return popElement;
    }

    public static int top() {
        if (SIZE == 0) {
            return -1;
        }
        int topElement = SIZE - 1;
        return stack[topElement];
    }

    public static int empty() {
        return SIZE == 0 ? 1 : 0;
    }

    public static int size() {
        return SIZE;
    }
}
