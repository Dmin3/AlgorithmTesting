import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Number24482 {
    static int n,m, r;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        result = new int[n + 1];
        Arrays.fill(result, -1);

        // 그래프 초기화
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

        for (List<Integer> list : graph) {
            Collections.sort(list, Collections.reverseOrder());
        }

        dfs(r, 0);

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static void dfs(int start, int depth) {
        visited[start]= true;
        result[start]= depth;

        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
            }
        }
    }
}
