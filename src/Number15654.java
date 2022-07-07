import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number15654 {
    /**
     * N과M(5)번 문제
     */
    public static int[] arr;
    public static int[] result;
    public static boolean[] visit;
    public static int N,M;
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");

        result = new int[N];

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(result);

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth){
        if (depth == M){
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]){
                visit[i] = true;
                arr[depth] = result[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
