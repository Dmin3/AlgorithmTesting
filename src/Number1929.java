import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Number1929 {
    static int m, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        List<Integer> list = sosu(m, n);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static List<Integer> sosu(int m, int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        visited[0] = visited[1] = false;

        for (int i = 2; i <= n; i++) {
            visited[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j += i) {
                visited[j] = false;
            }
        }

        for (int i = m; i <= n; i++) {
            if (visited[i]) {
                result.add(i);
            }
        }


        return result;


    }
}
