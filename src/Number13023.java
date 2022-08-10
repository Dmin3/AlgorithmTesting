import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Number13023 {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ans = 0;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            if (ans == 0) {
                dfs(i, 1);
            }
        }

        System.out.println(ans);
    }

    private static void dfs(int start, int depth) {
        if (depth == 5) {
            ans = 1;
            return;
        }

        visited[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            int y = graph.get(start).get(i);
            if (!visited[y]) {
                dfs(y, depth + 1);
            }
        }
        visited[start] = false;
    }
}
