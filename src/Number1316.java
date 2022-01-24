import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {


        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (check()) {
                count++;
            }
        }
        System.out.println(count);


    }

    public static boolean check() throws IOException {

        boolean[] check = new boolean[26];
        String s = br.readLine();
        int prev = 0;

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if (now != prev) {
                if (check[now - 'a'] == false) {
                    check[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
                continue;
            }
        }
        return true;
    }

}
