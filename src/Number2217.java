import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Number2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int x = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(sum, arr[i] * x);
            x--;
        }

        System.out.println(sum);

    }
}
