import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Number11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] coinTypes = new Integer[n];

        for (int i = 0; i < coinTypes.length; i++) {
            coinTypes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coinTypes, Collections.reverseOrder());

        int count = 0;

        for (int i = 0; i < coinTypes.length; i++) {
            int coin = coinTypes[i];
            count += k / coin;
            k = k % coin;
        }

        System.out.println(count);
    }
}
