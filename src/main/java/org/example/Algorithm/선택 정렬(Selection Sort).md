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
            if (arr[j] > arr[standard]) standard = j; // 3.
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

### 시간복잡도
데이터의 개수가 n개라 했을 때,
- 첫 번째 회전에서의 비교횟수 : 1 ~ (n-1) -> n-1 
- 두 번째 회전에서의 비교횟수 : 2 ~ (n-1) -> n-2
- ...
- (n-1) + (n-2) + .... + 2 + 1 -> n(n-1)/2

비교하는 것이 상수 시간에 이루어진다는 가정 아래, n개의 주어진 배열을 정렬하는데 O(n^2) 만큼의 시간이 걸린다.
최선, 평균, 최악의 경우 시간복잡도는 O(n^2) 으로 동일하다.

### 공간복잡도
- 주어진 배열 안에서 교환(swap)을 통해, 정렬이 수행되므로 O(n) 이다.

### 장점
- Bubble Sort와 마찬가지로 알고리즘이 단순하다.
- 정렬을 위한 비교 횟수는 많지만, Bubble Sort에 비해 실제로 교환하는 횟수는 적기 때문에 `많은 교환이 일어나야 하는 자료상태에서 비교적 효율적`이다.
- Bubble Sort와 마찬가지로 정렬하고자 하는 배열 안에서 교환하는 방식이므로, 다른 메모리 공간을 필요로 하지 않는다.
  - 제자리 정렬

### 단점
- 시간복잡도가 O(n^2)로, 비효율적이다.
- 불안정 정렬(Unstable Sort) 이다.