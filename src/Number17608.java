import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number17608 {
    public static void main(String[] args) throws IOException {


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            for (int i=0; i< arr.length; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }

            int cnt = 1; //보이는 막대기 갯수
            int max = arr[arr.length -1]; // 처음막대기 배열 순서

            for (int i=arr.length -2; i>=0; i--){

                if (max < arr[i]){
                    max = arr[i];
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
}
