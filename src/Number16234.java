import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number16234 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, L, R;
    static boolean[][] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while (true) {
            boolean sw = false;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        ArrayList<int[]> list = bfs(i, j);
                        if (list.size() > 1) {
                            sw = true;
                            divide(list);
                        }
                    }
                }
            }
            if (!sw) break;
            cnt++;
        }

        System.out.println(cnt);
    }

    private static void divide(ArrayList<int[]> people) {
        int m = 0;
        for (int i = 0; i < people.size(); i++) {
            m += arr[people.get(i)[0]][people.get(i)[1]];
        }
        for (int i = 0; i < people.size(); i++) {
            arr[people.get(i)[0]][people.get(i)[1]] = m / people.size();
        }
    }

    private static ArrayList<int[]> bfs(int f_x, int f_y) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> temp = new ArrayList<>();
        q.add(new int[]{f_x, f_y});
        temp.add(new int[]{f_x, f_y});
        visited[f_x][f_y] = true;
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int val = Math.abs(arr[nx][ny] - arr[x][y]);
                    if (!visited[nx][ny] && L <= val && val <= R) {
                        q.add(new int[]{nx, ny});
                        temp.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return temp;
    }
}