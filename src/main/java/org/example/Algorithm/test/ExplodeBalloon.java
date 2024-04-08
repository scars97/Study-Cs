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

            sb.append(pop[0]).append(" ");

            if (balloon.size() == 1) {
                int[] lastPop = balloon.remove();
                sb.append(lastPop[0]).append(" ");
                break;
            }

            int writeNum = pop[1] < 0 ? -pop[1] : pop[1] - 1;

            for (int i = 0; i < writeNum; i++) {
                balloon.add(balloon.remove());
            }
        }

        System.out.println(sb);
    }
}
