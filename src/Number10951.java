import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number10951 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        String str;

        while ((str = br.readLine()) != null){


            st = new StringTokenizer(str, " ");
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");

        }

        System.out.println(sb);
    }
}
