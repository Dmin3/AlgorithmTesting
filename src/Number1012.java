import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number1012 {
    static int[][] arr;
    static int N, M, K;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int result = 0;

            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            visited = new boolean[N][M];
            arr = new int[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[X][Y] = 1;
            }

            for (int k = 0; k < N; k++) {
                for (int t = 0; t < M; t++) {
                    if (!visited[k][t] && arr[k][t] == 1) {
                        result += bfs(k, t);
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int k, int t) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k, t});

        visited[k][t] = true;

        while (!q.isEmpty()) {
            int now_x = q.peek()[0];
            int now_y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if (next_x >= 0 && next_y >= 0 && next_x < N && next_y < M) {
                    if (arr[next_x][next_y] == 1 && !visited[next_x][next_y]) {
                        visited[next_x][next_y] = true;
                        q.add(new int[]{next_x, next_y});
                    }
                }
            }
        }
        return 1;
    }
}
