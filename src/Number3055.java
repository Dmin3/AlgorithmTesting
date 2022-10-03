import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number3055 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int r, c;
    static char[][] map;
    static int ans = Integer.MAX_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];


        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        bfs();
        System.out.println(ans == Integer.MAX_VALUE ? "KAKTUS" : ans);
    }

    private static void bfs() {
        Queue<int[]> water = new LinkedList<>();
        Queue<int[]> hedgehog = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*' && !visited[i][j]) {
                    water.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (map[i][j] == 'S') {
                    hedgehog.add(new int[]{i, j, 0});
                }
            }
        }

        // 매분마다
        while (!hedgehog.isEmpty()) {

            int len = water.size();
            for (int i = 0; i < len; i++) {
                int water_now_x = water.peek()[0];
                int water_now_y = water.peek()[1];
                water.poll();

                for (int j = 0; j < 4; j++) {
                    int water_next_x = water_now_x + dx[j];
                    int water_next_y = water_now_y + dy[j];

                    if (water_next_x >= 0 && water_next_x < r && water_next_y >= 0 && water_next_y < c) {
                        if (map[water_next_x][water_next_y] == '.') {
                            map[water_next_x][water_next_y] = '*';
                            water.add(new int[]{water_next_x, water_next_y});
                        }
                    }
                }
            }

            len = hedgehog.size();
            for (int i = 0; i < len; i++) {
                int now_x = hedgehog.peek()[0];
                int now_y = hedgehog.peek()[1];
                int time = hedgehog.peek()[2];
                hedgehog.poll();

                for (int j = 0; j < 4; j++) {
                    int next_x = now_x + dx[j];
                    int next_y = now_y + dy[j];

                    if (next_x >= 0 && next_x < r && next_y >= 0 && next_y < c) {
                        if (map[next_x][next_y] == 'D') {
                            ans = Math.min(ans, time + 1);
                            return;
                        } else if (map[next_x][next_y] == '.') {
                            map[next_x][next_y] = 'S';
                            hedgehog.add(new int[]{next_x, next_y, time + 1});
                        }
                    }
                }
            }
        }
    }
}
