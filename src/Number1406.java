import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Number1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());


        int start = 0;
        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (start < input) {
                for (int i = start + 1; i <= input; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = input;
            } else if (stack.peek() != input) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);


    }
}
