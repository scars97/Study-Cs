package org.example.Algorithm.test;

import java.util.Scanner;

public class Yosepus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int random = (int) (Math.random() * N) + 1;
            System.out.println(random);
        }

    }
}
