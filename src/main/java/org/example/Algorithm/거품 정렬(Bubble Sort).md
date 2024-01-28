# 거품 정렬 (Bubble Sort)

---

- 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘이다.
- 인접한 2개의 원소를 비교해 크기가 순서대로 되어 있지 않으면 서로 교환한다.

### Process (Ascending)
- 1회전에 첫 번째 원소와 두 번째 원소와 세 번째 원소를, 세 번째 원소와 네 번째 원소를...
  - 이런 식으로 (마지막 - 1)번째 원소와 마지막 원소를 비교하여 조건에 맞지 않는다면 서로 교환한다.
- 1회전을 수행하고 나면 가장 큰 원소가 맨 뒤로 이동하므로 2회전에서는 맨 끝에 있는 원소는 정렬에서 제외되고,
- 2회전을 수행하고 나면 끝에서 두 번째 원소까지는 정렬에서 제외된다.
  - 이렇게 정렬을 1회전 수행할 때마다 정렬에서 제외되는 데이터가 하나씩 늘어난다.

```java
private static void sort(int[] arr) {
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

private static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
    }
    System.out.println();
}
```