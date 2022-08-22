import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number3184_DFS {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int wolf, sheep;
    static int sheepCount, wolfCount = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = chars[j];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    dfs(i, j);

                    if (sheepCount < wolfCount) {
                        wolf += wolfCount;
                    } else if (sheepCount == wolfCount) {
                        wolf += wolfCount;
                    } else {
                        sheep += sheepCount;
                    }

                    sheepCount = 0;
                    wolfCount = 0;
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    private static void dfs(int x, int y) {
        if (map[x][y] == 'o') {
            sheepCount++;
        } else if (map[x][y] == 'v') {
            wolfCount++;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x >= 0 && next_x < r && next_y >= 0 && next_y < c) {
                if (!visited[next_x][next_y] && map[next_x][next_y] != '#') {
                    dfs(next_x, next_y);
                }
            }
        }
    }
}
