package org.example;

public class Main {
    static int[] arr = {4,5,1,3,7,2,8,9,6};

    public static void main(String[] args) {
        sort();
    }
    private static void sort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
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