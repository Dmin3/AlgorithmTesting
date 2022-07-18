import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        bfs(a, b);
    }

    public static void bfs(long a, long b) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.x == b) {
                System.out.println(p.count + 1);
                return;
            }

            for (int i = 0; i < 2; i++) {
                long x = 0;

                if (i == 0) {
                    x = p.x * 2;
                } else {
                    x = p.x * 10 + 1;
                }

                if (p.x <= b) {
                    q.add(new Pair(x, p.count + 1));
                }

            }
        }
        System.out.println(-1);
    }

    static class Pair {
        long x;
        int count;

        public Pair(long a, int count) {
            this.x = a;
            this.count = count;
        }
    }
}
