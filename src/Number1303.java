import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number1303 {
    static char[][] map;
    static int n, m;
    static int count;
    static int wsum, bsum;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 'W'){
                    int num = bfs(i, j, 'W');
                    wsum += num * num;
                } else if(map[i][j] == 'B') {
                    int num = bfs(i, j, 'B');
                    bsum += num * num;

                }
            }
        }

        System.out.println(wsum + " " + bsum);
    }

    private static int bfs(int x, int y, char ch) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        count = 1;
        map[x][y] = ' ';

        while (!q.isEmpty()) {
            int now_x = q.peek()[0];
            int now_y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if (next_x >= 0 && next_y >= 0 && next_x < n && next_y < m) {
                    if (map[next_x][next_y] == ch) {
                        q.add(new int[]{next_x, next_y});
                        map[next_x][next_y] = ' ';
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
