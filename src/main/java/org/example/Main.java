package org.example;

import java.util.Arrays;

public class Main {
    static int[] arr = {7, 6, 2, 4, 3, 9, 1};

    public static void main(String[] args) {
        insertionSort();
        //selectionSort();
        //bubbleSort();
    }

    // Quick Sort
    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        // partition - 배열 그룹 분리
        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr) swap(a, pl++, pr--);
        } while (pl <= pr);
    }

    private static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2]= t;
    }

    // Insertion Sort
    static void insertionSort() {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int prev = i - 1;

            while ((0 <= prev) && temp < arr[prev]) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    // Selection Sort
    static void selectionSort() {
        for (int i = 0; i < arr.length; i++) { // 1.
            int standard = i;
            for (int j = i + 1; j < arr.length; j++) { // 2.
                if (arr[j] < arr[standard]) standard = j; // 3.
            }

            int temp = arr[standard];
            arr[standard] = arr[i];
            arr[i] = temp;

            System.out.print((i + 1) + "단계 : ");
            print(arr);
        }
    }

    // Bobble Sort
    static void bubbleSort() {
        for (int i = 0; i < arr.length; i++) { // 1.
            for (int j = 0; j < arr.length - i - 1; j++) { // 2.
                if (arr[j] > arr[j + 1]) { // 3.
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.print((i + 1) + "단계 : ");
            print(arr);
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}