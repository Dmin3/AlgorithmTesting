import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number10815 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        arr = new int[Integer.parseInt(br.readLine())];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            sb.append(searchNum(Integer.parseInt(st.nextToken())) + " ") ;
        }

        System.out.println(sb);
    }

    private static int searchNum(int num) {
        int left = 0;
        int right = arr.length -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return 1;
            } else if (arr[mid] < num){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
