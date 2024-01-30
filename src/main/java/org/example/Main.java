package org.example;

import java.util.Arrays;

public class Main {
    static int[] arr = {7, 6, 2, 4, 3, 9, 1};

    public static void main(String[] args) {
        //bubbleSort();
        selectionSort();
    }

    // Selection Sort
    private static void selectionSort() {
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
    private static void bubbleSort() {
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