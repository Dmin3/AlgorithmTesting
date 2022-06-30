import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number15649 {
    public static int[] arr;
    public static boolean[] visit;
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);
        System.out.println(sb);
    }

    /**
     *
     * @param n = 자연수 크기 N
     * @param m = 배열의 크기
     * @param depth = 스위치 역할 (깊이 조절)
     */
    private static void dfs(int n, int m, int depth) {
        if (depth == m){
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(n, m, depth + 1);
                visit[i] = false;
            }
        }
    }
}
