import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질
 */
public class Number1697 {
    static int n, k;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int index = q.poll();

            if (index == k) {
                System.out.println(visited[index]);
                break;
            }
            if (index + 1 <= 100000 && visited[index + 1] == 0) {
                visited[index + 1] = visited[index] + 1;
                q.add(index + 1);
            }
            if (index - 1 >= 0  && visited[index - 1] == 0) {
                visited[index - 1] = visited[index] + 1;
                q.add(index - 1);
            }
            if (index * 2 <= 100000 && visited[index * 2] == 0) {
                visited[index * 2] = visited[index] + 1;
                q.add(index * 2);
            }
        }
    }
}
