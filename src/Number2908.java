import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number2908 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int num1 = reverse(a); // 숫자 거꾸로 출력
        int num2 = reverse(b); // 숫자 거꾸로 출력

        if (num1 < num2){
            System.out.println(num2);
        } else {
            System.out.println(num1);
        }
    }

    // 메소드 작성
    public static int reverse(int num){
        int result = 0;
        while(num!=0){
            result= result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }
}
