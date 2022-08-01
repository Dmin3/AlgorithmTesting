import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number5014 {
    static int f,s,g,u,d;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[f + 1];
        visited = new boolean[f + 1];

        if (u == 0 && d == 0) {
            System.out.println("use the stairs");
        } else if (s < g && u == 0){
            System.out.println("use the stairs");
        } else if (s > g && d == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(bfs(s, g));
        }
    }

    private static String bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == end) {
                return String.valueOf(arr[now]);
            }

            if (now + u < arr.length && !visited[now + u]) {
                arr[now + u] = arr[now] + 1;
                visited[now + u] = true;
                q.add(now + u);
            }

            if (now - d > 0 && !visited[now - d]) {
                arr[now - d] = arr[now] + 1;
                visited[now - d] = true;
                q.add(now - d);
            }
        }
        return "use the stairs";
    }
}
