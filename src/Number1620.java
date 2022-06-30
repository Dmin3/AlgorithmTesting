import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Number1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map.put(str , Integer.toString(i));
            map.put(Integer.toString(i), str);
        }

        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            sb.append(map.get(key)).append("\n");
        }

        System.out.println(sb);
    }
}
