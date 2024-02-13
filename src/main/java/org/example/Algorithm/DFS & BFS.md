# DFS & BFS

---

알고리즘 문제를 풀 때 상당히 많이 사용되며, 경로를 찾는 문제에서 상황에 맞게 DFS와 BFS를 활용하게 된다.

## BFS
- `너비 우선 탐색`이라 하며 Breadth-First Search 라 부른다.
- 루트 노트 혹은 임의의 노드에서 시작해 인접한 노드를 먼저 탐색하는 방법.
- 시작 정점으로부터 가까운 정점을 먼저 방문하고, 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법이다.
- 즉, 깊게 탐색하기 전에 넓게 탐색하는 것.
- 큐를 사용한다.
- 최소비용(모든 곳을 탐색하는 것보다 비용이 우선일 때)에 적합하다.
- 시간복잡도
  - 인접 행렬: O(V^2)
  - 인접 리스트: O(V+E)

<img src="https://upload.wikimedia.org/wikipedia/commons/5/5d/Breadth-First-Search-Algorithm.gif">

[Code]
```java

```


## DFS
- 깊이 우선 탐색이며 Depth-First Search 라고 부른다.
- 루트 노드 혹은 임의 노드에서 다음 브랜치로 넘어가기 전에, 해당 브랜치를 모두 탐색하는 방법.
- 넓게 탐색하기 전에 깊에 탐색하는 것.
- 스택 or 재귀함수를 통해 구현한다.
- 모든 경로를 방문해야 할 경우에 사용한다.
- 미로를 탐색할 때 한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게 되면 다시 가장 가까운 갈림길로 돌아와서 이곳으로부터 다른 방향으로 다시 탐색을 진행하는 방법과 유사하다.

<img src="https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif">