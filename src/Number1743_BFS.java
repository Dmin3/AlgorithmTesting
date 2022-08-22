import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number1743_BFS {
    /**
     * BFS 풀이
     */
    static int[][] map;
    static boolean[][] visited;
    static int n, m, k;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    result = Math.max(bfs(i, j), result);
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int count = 1;
        visited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int now_x = q.peek()[0];
            int now_y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m) {
                    if (!visited[next_x][next_y] && map[next_x][next_y] == 1){
                        q.add(new int[]{next_x, next_y});
                        visited[next_x][next_y] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
