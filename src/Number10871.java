import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number10871 {

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(str.nextToken());
        int X = Integer.parseInt(str.nextToken());

        //String 성능최적화
        StringBuilder sb = new StringBuilder();

        // 생성자 초기화
        str = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(str.nextToken());

            if (val < X){
                sb.append(val).append(" ");
            }
        }
        System.out.println(sb);







    }
}
