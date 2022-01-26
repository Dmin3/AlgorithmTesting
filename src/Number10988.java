import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number10988 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringBuilder input = sb.append(br.readLine());

        String s1 = String.valueOf(input);

        StringBuilder reverse = sb.reverse();
        String s2 = String.valueOf(reverse);

        if (s1.contains(s2)){
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }
}
