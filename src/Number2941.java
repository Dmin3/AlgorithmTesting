import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number2941 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String val = "c=|c-|dz=|d-|lj|nj|s=|z=";
        String s = br.readLine();
        String s1 = s.replaceAll(val, ".");

        System.out.println(val);
        System.out.println(s1.length());

    }
}
