import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number20037 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            int t = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<t; j++){
                int num = Integer.parseInt(st.nextToken());
                if (max < num){
                    max  = num;
                }
                if (min > num) {
                    min = num;
                }
            }
            sb.append(min + " " + max + "\n");

        }

        System.out.println(sb);



    }
}
