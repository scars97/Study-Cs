package org.example.Algorithm.test;

import java.util.*;

public class PrinterQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCnt = sc.nextInt();

        for (int i = 0; i < testCnt; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            LinkedList<int[]> files = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                files.add(new int[] {j, sc.nextInt()});
            }

            int count = 0;

            while (!files.isEmpty()) {
                int[] front = files.poll();
                boolean isMax = true;

                for (int j = 0; j < files.size(); j++) {
                    if (front[1] < files.get(j)[1]) {
                        files.add(front);

                        for (int k = 0; k < j; k++) {
                            files.add(files.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(!isMax) {
                    continue;
                }

                count++;
                if(front[0] == M) {
                    break;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
