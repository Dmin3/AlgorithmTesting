import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Number24444 {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int n,m, r;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        bfs(r);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = count;

        while (!q.isEmpty()) {
            int now_node = q.poll();

            for (int i = 0; i < graph[now_node].size(); i++) {
                int y = graph[now_node].get(i);

                if (visited[y] == 0) {
                    q.add(y);
                    visited[y] = ++count;
                }
            }
        }
    }
}
