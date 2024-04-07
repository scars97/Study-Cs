package org.example.Algorithm.test;

import java.util.LinkedList;
import java.util.Scanner;

public class ExplodeBalloon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<int[]> balloon = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            balloon.add(new int[]{i + 1, sc.nextInt()});
        }

        while (!balloon.isEmpty()) {
            int[] pop = balloon.remove();

            int balloonNum = pop[0];
            sb.append(balloonNum).append(" ");

            int writeNum = pop[1];

            if (writeNum < 0) {
                for (int j = 0; j < -writeNum; j++) {
                    int[] removeLast = balloon.removeLast();
                    balloon.addFirst(removeLast);
                }
            } else {
                for (int j = 0; j < writeNum - 1; j++) {
                    int[] removeFirst = balloon.removeFirst();
                    balloon.addLast(removeFirst);
                }
            }

            if (balloon.size() == 1) {
                int[] lastPop = balloon.remove();
                sb.append(lastPop[0]).append(" ");
            }
        }

        System.out.println(sb);

    }
}
