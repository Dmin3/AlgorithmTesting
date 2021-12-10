import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number1110 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int copy = n;
        int count = 0;

        while (true){
            n = ((n % 10) * 10) + (((n/10) + (n % 10)) % 10);
            count++;

            if (n == copy){
                break;
            }
        }

        System.out.println(count);
    }
}
