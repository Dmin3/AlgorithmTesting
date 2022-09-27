import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number15663 {
    static int n, m;
    static int[] arr, result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        back(0);


        System.out.println(sb);

    }

    private static void back(int depth) {
        if (depth == m) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        } else {
            int before = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                } else {
                    if (before != arr[i]) {
                        visited[i] = true;
                        result[depth] = arr[i];
                        before = arr[i];
                        back(depth + 1);
                        visited[i] = false;
                    }
                }

            }
        }
    }
}
