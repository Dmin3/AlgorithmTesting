import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number9093 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        String s;

        for (int i =0; i < T; i++){
            st = new StringTokenizer(br.readLine(), " ");

            while (st.hasMoreTokens()){
                s = st.nextToken();

                for (int j= s.length()-1; j >= 0; j--){
                    sb.append(s.charAt(j));
                }
                sb.append(" ");
            }
            sb.append("\n");

        }

        System.out.println(sb);






    }

}
