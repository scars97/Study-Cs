# 선택 정렬 (Selection Sort)

---

정렬 알고리즘은 다음으로 나눌 수 있다.
- 단순하지만 비효율적인 방법 : 선택 정렬, 삽입 정렬, 버블 정렬
- 복잡하지만 조금 더 효율적인 방법 : 퀵 정렬, 힙 정렬, 합병 정렬, 기수 정렬

---

- `해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘`이다.
- 현재 위치에 저장될 값의 크기가 작은지, 큰지에 따라서 최소 선택 정렬(오름차순)과 최대 선택 정렬(내림차순)로 나뉜다.

### Process (Ascending)
- 주어진 배열에서 첫 번째 인덱스를 기준으로 잡는다. 기준은 처음부터 시작한다.
- 주어진 배열에서 기준 이후의 값 중 최소값을 찾는다.
- 최소값과 그 기준의 값을 교체한다.
- 기준 이후의 나머지 배열을 같은 방법으로 교체한다.
```java
int[] arr = {7, 6, 2, 4, 3, 9, 1};

private static void selectionSort() {
    for (int i = 0; i < arr.length; i++) { // 1.
        int standard = i;
        for (int j = i + 1; j < arr.length; j++) { // 2.
            // 오름차순
            if (arr[j] < arr[standard]) standard = j; // 3.
        }

        int temp = arr[standard];
        arr[standard] = arr[i];
        arr[i] = temp;

        System.out.println(Arrays.toString(arr));
    }
}
```
- 위치(index)를 선택해준다.
- i + 1 번째 원소부터 선택한 위치(index)의 값과 비교를 시작한다.
- 오름차순이므로 현재 선택한 자리에 있는 값보다 순회하고 있는 값이 작다면, 위치(index)를 갱신해준다.
- '2' 번 반복문이 끝난 뒤에는 standard에 '1'번에서 선택한 위치에(index)에 들어가야하는 값의 위치(index)를 갖고 있으므로 서로 교환(swap)해준다.

<img src="https://github.com/GimunLee/tech-refrigerator/raw/master/Algorithm/resources/selection-sort-001.gif">