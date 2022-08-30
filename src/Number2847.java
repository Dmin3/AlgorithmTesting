import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 내림차순으로 비교하면서 갱신
        int sum = 0;
        for (int i = n - 1; i > 0; i--) {
            int count = 0;
            if (arr[i] <= arr[i - 1]) {
                count = (arr[i - 1] - arr[i]) + 1;
                sum += count;
                arr[i - 1] = arr[i - 1] - count;
            }
        }

        System.out.println(sum);
    }
}
