import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number1439 {
    public static void main(String[] args) throws IOException {

        BufferedReader be = new BufferedReader(new InputStreamReader(System.in));

        String s = be.readLine();

        StringTokenizer st1 = new StringTokenizer(s, "0");
        StringTokenizer st2 = new StringTokenizer(s, "1");

        System.out.println(Math.min(st1.countTokens(), st2.countTokens()));


    }
}
