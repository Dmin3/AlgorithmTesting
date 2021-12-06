import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number11720 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int sum = 0;

        for (int i=0;i<T;i++){
            char val = str.charAt(i);
            int a = val - '0';
            sum += a;
        }

        System.out.println(sum);

    }
}
