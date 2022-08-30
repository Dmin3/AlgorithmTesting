import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number13565 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        boolean result = false;
        for (int i = 0; i < m; i++) {
            if (map[0][i] == 0) {
                if (bfs(0, i)) {
                    result = true;
                    break;
                }
            }
        }

        System.out.println(result ? "YES" : "NO");
    }

    private static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int now_x = q.peek()[0];
            int now_y = q.peek()[1];

            int end = now_x + 1;
            if (end == n) {
                return true;
            }

            q.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m) {
                    if (map[next_x][next_y] == 0 && !visited[next_x][next_y]) {
                        visited[next_x][next_y] = true;
                        q.add(new int[]{next_x, next_y});
                    }
                }
            }
        }
        return false;
    }
}
