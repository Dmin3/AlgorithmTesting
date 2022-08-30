import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), ".", true);


        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals(".")) {
                sb.append(s);

            } else {

                if (s.length() % 2 != 0) {
                    System.out.println(-1);
                    System.exit(0);
                    break;
                }

                if (s.length() % 4 == 0) {
                    int idx = s.length() / 4;
                    for (int i = 0; i < idx; i++) {
                        sb.append("AAAA");
                    }
                } else if (s.length() % 4 == 2) {
                    int idx = s.length() / 4;
                    for (int i = 0; i < idx; i++) {
                        sb.append("AAAA");
                    }
                    sb.append("BB");
                } else {
                    sb.append("BB");
                }
            }
        }

        System.out.println(sb);




    }
}
