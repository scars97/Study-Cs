package org.example.Algorithm.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ExplodeBalloon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<int[]> balloon = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            balloon.add(new int[]{i + 1, sc.nextInt()});
        }

        while (!balloon.isEmpty()) {
            int[] pop = balloon.remove();

            sb.append(pop[0]).append(" ");

            if (balloon.size() == 1) {
                int[] lastPop = balloon.remove();
                sb.append(lastPop[0]).append(" ");
                break;
            }

            int writeNum = pop[1];

            if (writeNum < 0) {
                for (int i = 0; i < -writeNum; i++) {
                    balloon.addFirst(balloon.removeLast());
                }
            } else {
                for (int i = 0; i < writeNum - 1; i++) {
                    balloon.add(balloon.remove());
                }
            }
        }

        System.out.println(sb);
    }
}
