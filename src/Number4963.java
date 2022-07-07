import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number4963 {
    static int[][] arr;
    static boolean[][] visited;
    static int N,M;
    static int[] dx = {-1, 1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, -1 ,1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true){
            int count = 0;
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            arr = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]){
                        count += bfs(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int now_x = q.peek()[0];
            int now_y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 8; i++) {
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
