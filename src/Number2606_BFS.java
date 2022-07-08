import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Number2606_BFS {
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int n, m;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향 설정
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);
        System.out.println(count);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int now_node = q.poll();
            int y;
            for (int i = 0; i < graph.get(now_node).size(); i++) {
                y = graph.get(now_node).get(i);
                if (!visited[y]) {
                    visited[y] = true;
                    count++;
                    q.add(y);
                }
            }
        }
    }
}
