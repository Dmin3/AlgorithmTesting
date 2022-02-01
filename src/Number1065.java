import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number1065 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;

        for (int i = 1; i <= N; i++) {

            int cnt = hanSu(i);
            sum += cnt;
        }

        System.out.println(sum);


    }

    public static int hanSu(int num){

        if (num < 100){
            return 1;
        } else if (num == 1000){
            return 0;
        }


        int[] arr = new int[3]; // 각 자릿수를 넣을 배열



        for (int i = 0; i < arr.length; i++) {
            // 자릿수 구하는 방법
            int a = num % 10;
            arr[i] = a;
            num = num / 10;
        }

        if (arr[2] - arr[1] == arr[1] - arr[0]){ // 배열안 값들에 공차가 같은지 판별
            return 1;
        }
        return 0;
    }


}
