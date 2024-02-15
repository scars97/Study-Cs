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
<blockquote>
정점 : V <br>
간선 : E
</blockquote>

<img src="https://upload.wikimedia.org/wikipedia/commons/5/5d/Breadth-First-Search-Algorithm.gif">

[Code]
```java
public class BFS {
  private static final String SPACE = " ";
  private static ArrayList<Integer>[] a;
  private static boolean[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(SPACE);
    int n = convert(input[0]); // 정점의 개수
    int m = convert(input[1]); // 간선의 개수
    int start = convert(input[2]); // 시작할 정점 번호

    // 배열 초기화
    a = new ArrayList[n + 1];

    for (int i = 1; i <= n; i++) {
      a[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      String[] inputs = br.readLine().split(SPACE);
      int u = convert(input[0]);
      int v = convert(input[1]);

      // 양방향 그래프일 경우 양쪽 다 추가해준다.
      a[u].add(v);
      a[v].add(u);
    }

    // 방문할 정점이 여러 개인 경우 정점 번호가 가장 작은 것부터 탐색하기 위해서 정렬한다.
    for (int i = 1; i <= n; i++) {
      Collections.sort(a[i]);
    }

    visit = new boolean[n + 1];
    bfs(start);
    System.out.println();
  }

  private static int convert(String command) {
    return Integer.parseInt(command);
  }

  private static void bfs(int start) {
    LinkedList<Integer> queue = new LinkedList<>();

    visit[start] = true;
    queue.add(start);

    while (!queue.isEmpty()) {
      int x = queue.remove(); // 큐에서 정점을 뺀다.

      System.out.print(x + SPACE);

      for (int y : a[x]) {
        // 방문한 적이 있는지 체크
        if (!visit[y]) {
          // 해당 정점을 방문한 적이 없다면 방문했다고 true로 체크
          // 그리고 해당 정점을 큐에 넣는다.
          visit[y] = true;
          queue.add(y);
        }
      }
    }
  }
}
```

## DFS
- `깊이 우선 탐색`이며 Depth-First Search 라고 부른다.
- 루트 노드 혹은 임의 노드에서 다음 브랜치로 넘어가기 전에, 해당 브랜치를 모두 탐색하는 방법.
- 넓게 탐색하기 전에 깊에 탐색하는 것.
- 스택 or 재귀함수를 통해 구현한다.
- 모든 경로를 방문해야 할 경우에 사용한다.
- 미로를 탐색할 때 한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게 되면 다시 가장 가까운 갈림길로 돌아와서 이곳으로부터 다른 방향으로 다시 탐색을 진행하는 방법과 유사하다.

<img src="https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif">