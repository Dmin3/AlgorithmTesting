import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number1476 {
    static int e, s, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int count = 0;
        int now_e = 0;
        int now_s = 0;
        int now_m = 0;
        while (true){
            if (e == now_e && s == now_s && m == now_m) {
                break;
            }

            now_e++;
            now_s++;
            now_m++;

            if (now_e > 15) {
                now_e = 1;
            }
            if (now_s > 28) {
                now_s = 1;
            }
            if (now_m > 19) {
                now_m = 1;
            }
            count++;
        }

        System.out.println(count);

    }
}
