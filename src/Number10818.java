import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number10818 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());

        long min = 1000000;
        long max = -1000000;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i < n; i++){
            long a = Integer.parseInt(st.nextToken());
            if (a < min){
                min = a;
            }
            if (max < a){
                max = a;
            }
        }
        System.out.println(min + " " + max);



    }

}
