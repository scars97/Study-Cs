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

        int i = N;
        while (!balloon.isEmpty()) {
            int size = balloon.size();

            int[] pop = balloon.remove(size - i);

            int balloonNum = pop[0];
            sb.append(balloonNum).append(" ");

            int writeNum = pop[1];
            if (writeNum < 0) {
                i = size + writeNum;
            } else {
                i = size - writeNum;
            }

        }

        System.out.println(sb);

    }
}
