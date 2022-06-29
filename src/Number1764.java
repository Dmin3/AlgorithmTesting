import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Number1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> a = new HashSet<>();
        Set<String> b= new HashSet<>();
        for (int i = 0; i < n; i++) {
            a.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            b.add(br.readLine());
        }

        a.retainAll(b);

        List<String> collect = a.stream().collect(Collectors.toList());
        Collections.sort(collect);

        sb.append(collect.size() + "\n");
        for (String s : collect) {
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}
