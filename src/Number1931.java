import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Number1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

        int count = 0;
        int end_time = 0;

        for(int i = 0; i < n; i++) {

            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if(end_time <= arr[i][0]) {
                end_time = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
