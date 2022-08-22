import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sum = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            int count = findSosu(num);
            sum += count;
        }

        System.out.println(sum);
    }

    private static int findSosu(int num) {
        if (num == 1) {
            return 0;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return 0;
            }
        }

        return 1;
    }
}
