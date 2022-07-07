import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Number2667 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }

        sb.append(result.size()).append("\n");
        Collections.sort(result);
        for (Integer integer : result) {
            sb.append(integer).append("\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int count = 1;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int now_x = q.peek()[0];
            int now_y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if (next_x >= 0 && next_y >= 0 && next_x < N && next_y < N) {
                    if (arr[next_x][next_y] == 1 && !visited[next_x][next_y]) {
                        visited[next_x][next_y] = true;
                        q.add(new int[]{next_x, next_y});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
