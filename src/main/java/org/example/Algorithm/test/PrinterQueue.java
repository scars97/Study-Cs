package org.example.Algorithm.test;

import com.sun.jdi.ArrayReference;

import java.util.*;

public class PrinterQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCnt = sc.nextInt();

        int[] files;
        for (int i = 0; i < testCnt; i++) {
            int N = sc.nextInt(); // 문서 개수
            int M = sc.nextInt(); // 출력 문서 위치 순번

            files = new int[N];

            int peek = 0;
            int result = 0;
            // 입력 받은 문서 q.add()
            for (int j = 0; j < N; j++) {
                int importance = sc.nextInt();
                if (j == M) {
                    peek = importance;
                }
                files[j] = importance;
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
            sb.append(result);
        }

        System.out.println(sb);
    }

    public static Queue<Integer> descendingSort(int[] files) {
        Queue<Integer> sortedFile = new LinkedList<>();

        int length = files.length;

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length - i; j++) {
                if (files[j - 1] <= files[j]) {
                    int temp = files[j - 1];
                    files[j - 1] = files[j];
                    files[j] = temp;
                }
            }
        }

        for (int file : files) {
            sortedFile.add(file);
        }

        return sortedFile;
    }
}
