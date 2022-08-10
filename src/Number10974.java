import java.util.Scanner;

public class Number10974 {
    static int[] nums;
    static int[] temp;
    static boolean[] visited;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        visited = new boolean[n];

        nums = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        back(0);
        System.out.println(sb);
    }

    private static void back(int cnt) {
        if (cnt == n) {
            for (int i : temp) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[cnt] = nums[i];
                back(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
