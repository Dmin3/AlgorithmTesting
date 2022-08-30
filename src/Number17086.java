import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number17086 {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1, 1, -1, 1, -1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    visited = new boolean[n][m];
                    int cnt = bfs(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }

        System.out.println(max);

    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int now_x = q.peek()[0];
            int now_y = q.peek()[1];
            int count = q.peek()[2];
            q.poll();

            if (map[now_x][now_y] == 1) {
                return count;
            }

            for (int i = 0; i < 8; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m) {
                    if (!visited[next_x][next_y]) {
                        visited[next_x][next_y] = true;
                        q.add(new int[]{next_x, next_y, count + 1});
                    }
                }
            }
        }
        return 0;
    }
}
