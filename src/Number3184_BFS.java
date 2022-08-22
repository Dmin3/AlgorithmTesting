import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number3184_BFS {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int wolf, sheep;
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
                // 울타리가 아닐때만 BFS 진입
                if (!visited[i][j] && map[i][j] != '#') {
                    bfs(i, j);
                }

            }
        }

        System.out.println(sheep + " " + wolf);
    }

    private static void bfs(int x, int y) {
        int wolfCount = 0; // 늑대 수
        int sheepCount = 0; // 양 수

        // 처음 들어오는 좌표가 양인지 늑대인지 확인
        if (map[x][y] == 'o') {
            sheepCount++;
        } else if (map[x][y] == 'v') {
            wolfCount++;
        }

        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int now_x = q.peek()[0];
            int now_y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                // 다음 좌표 값 설정
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                // 배열 범위 지정
                if (next_x >= 0 && next_x < r && next_y >= 0 && next_y < c) {
                    // 방문하지 않고 울타리가 아니라면 진입
                    if (!visited[next_x][next_y] && map[next_x][next_y] != '#') {
                        // 양인지 늑대인지 판단
                        if (map[next_x][next_y] == 'o') {
                            sheepCount++;
                        } else if (map[next_x][next_y] == 'v') {
                            wolfCount++;
                        }
                        // Queue 에 넣어 주고 방문 처리
                        visited[next_x][next_y] = true;
                        q.add(new int[]{next_x, next_y});
                    }
                }
            }
        }

        // while문이 끝난 후 늑대와 양의 수를 판단하여 값 저장
        if (wolfCount > sheepCount){
            wolf += wolfCount;
        } else if (wolfCount == sheepCount){
            wolf += wolfCount;
        } else {
            sheep += sheepCount;
        }
    }
}
