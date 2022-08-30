import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number6118 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);

        int index = 0;
        int temp = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > temp){
                index = i;
                temp = dist[i];
            }
        }

        int count = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[index] == dist[i]) {
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(index).append(" ").append(dist[index]).append(" ").append(count);
        System.out.println(sb);

    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int now_node = q.poll();

            for (int i = 0; i < graph.get(now_node).size(); i++) {
                int y = graph.get(now_node).get(i);

                if (!visited[y]){
                    visited[y] = true;
                    q.add(y);
                    dist[y] = dist[now_node] + 1;
                }
            }
        }
    }
}
