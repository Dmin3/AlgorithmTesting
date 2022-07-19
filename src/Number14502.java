import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number14502 {
    static int[][] map;
    static int n, m, max = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(0);

        System.out.println(max);
    }

    private static void back(int wall) {
        if (wall == 3) {
            bfs(map);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    back(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }


    private static void bfs(int[][] map) {
        Queue<int[]> q = new LinkedList<>();

        int[][] copy_map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy_map[i][j] = map[i][j];
                if (copy_map[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] que = q.poll();
            int now_x = que[0];
            int now_y = que[1];

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if (next_x >= 0 && next_y >= 0 && next_x < n && next_y < m) {
                    if (copy_map[next_x][next_y] == 0) {
                        copy_map[next_x][next_y] = 2;
                        q.add(new int[]{next_x, next_y});
                    }
                }
            }
        }

        max = Math.max(max, check(copy_map));
    }

    private static int check(int[][] copy_map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy_map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
