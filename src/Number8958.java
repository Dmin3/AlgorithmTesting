import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number8958 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        String[] arr = new String[t];

        for (int i = 0; i < t; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < t; i++) {
            int count = 0;
            int sum = 0;
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == 'O') {
                    count++;
                } else {
                    count = 0;
                }
                sum += count;
            }
            sb.append(sum).append("\n");

        }
        System.out.println(sb);
    }
    }
