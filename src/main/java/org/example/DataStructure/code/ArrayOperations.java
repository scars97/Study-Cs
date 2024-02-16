package org.example.DataStructure.code;

public class ArrayOperations {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        System.out.println("배열 초기 상태:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        insertElement(arr, 25);
        System.out.println("요소 삽입 후:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        deleteElement(arr, 1);
        System.out.println("요소 삭제 후:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void insertElement(int[] arr, int element) {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = element;
    }

    static void deleteElement(int[] arr, int index) {
        // 배열의 크기보다 작거나 같은 유효한 인덱스에만 삭제 가능
        if (index < 0 || index >= arr.length) {
            System.out.println("유효하지 않은 인덱스입니다.");
            return;
        }

        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = 0;
    }
}
