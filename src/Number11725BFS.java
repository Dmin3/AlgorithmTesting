import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number11725BFS {
    static ArrayList<Integer>[] list;
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            list[v].add(u);
            list[u].add(v);
        }

        int[] result = new int[n + 1];

//        for (ArrayList<Integer> list : list) {
//            System.out.print(list + " ");
//        }

        bfs(1, result);

        for (int i = 2; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static void bfs(int start, int[] result) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now_node = q.poll();

            for (int i = 0; i < list[now_node].size(); i++) {
                int y = list[now_node].get(i);
                if (!visited[y]) {
                    visited[y] = true;
                    q.add(y);
                    result[y] = now_node;
                }
            }
        }
    }
}
