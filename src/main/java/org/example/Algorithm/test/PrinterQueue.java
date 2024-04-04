package org.example.Algorithm.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCnt = sc.nextInt();

        Queue<Integer> files = new LinkedList<>();
        for (int i = 0; i < testCnt; i++) {
            int N = sc.nextInt(); // 문서 개수
            int M = sc.nextInt(); // 출력 문서 위치 순번

            int peek = 0;
            int result = 0;
            // 입력 받은 문서 q.add()
            for (int j = 0; j < N; j++) {
                int importance = sc.nextInt();
                if (j == M) {
                    peek = importance;
                }
                files.add(importance);
            }

            // 내림차순 정렬
            Queue<Integer> sortedFiles = descendingSort(files);

            // 문서 출력 순번 결과
            for (int j = 0; j < N; j++) {
                int file = sortedFiles.remove();
                if (peek == file) {
                    result = j + 1;
                    break;
                }
            }

            files.clear();
            sb.append(result);
        }

        System.out.println(sb);
        
    }

    public static Queue<Integer> descendingSort(Queue<Integer> files) {

        return files;
    }
}
