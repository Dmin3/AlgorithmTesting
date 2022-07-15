import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Number10026 {
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int result = 0;
        int twoResult = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 'R') {
                        result += bfs(i, j, 'R');
                    } else if (map[i][j] == 'G') {
                        result += bfs(i, j, 'G');
                    } else {
                        result += bfs(i, j, 'B');
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 'R') {
                        twoResult += bfs(i, j, 'R');
                    } else {
                        twoResult += bfs(i, j, 'B');
                    }
                }
            }
        }

        System.out.println(result + " " + twoResult);

    }

    private static int bfs(int x, int y, char ch) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int now_x = q.peek()[0];
            int now_y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if (next_x >= 0 && next_y >= 0 && next_y < n && next_x < n) {
                    if (!visited[next_x][next_y] && map[next_x][next_y] == ch){
                        visited[next_x][next_y] = true;
                        q.add(new int[]{next_x, next_y});
                    }
                }
            }


        }

        return 1;
    }
}
