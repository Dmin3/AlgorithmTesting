import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number2644 {
    /**
     * 이해 하고 넘어가기 (촌수계산)
     */
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n, m;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        //초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 양방향 설정
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs(start, end);

        int answer = visited[end] > 0 ? visited[end] : -1;
        System.out.println(answer);

    }

    private static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int now_node = q.poll();

            if (now_node == end) {
                return;
            }

            for (int n : graph.get(now_node)) {
                if (visited[n] == 0){
                    visited[n] = visited[now_node] + 1;
                    q.add(n);
                }

            }
        }
    }
}
