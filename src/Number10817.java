import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number10817 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 공백으로 분리
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[3];
        int temp = 0;

        for (int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 2; i++){
            for (int j = i + 1; j < 3; j++){
                if (arr[i] > arr[j]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println(arr[1]);

    }
}
