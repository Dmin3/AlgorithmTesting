import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Number2606_DFS {
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int n,m;
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
//        for (ArrayList<Integer> list : graph) {
//            System.out.print(list + " ");
//        }
//        System.out.println();

        dfs(1);
        System.out.println(count - 1);

    }

    private static void dfs(int start) {
        count++;
        visited[start] = true;
        int y;
        for (int i = 0; i < graph.get(start).size(); i++) {
            y = graph.get(start).get(i);
            if (!visited[y]){
                dfs(y);
            }
        }
    }
}
