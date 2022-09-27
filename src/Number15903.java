import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Number15903 {
    static int n,m;
    static long[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        card = new long[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < card.length; i++) {
            card[i] = Long.parseLong(st.nextToken());
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();


        for (int i = 0; i < card.length; i++) {
            pq.offer(card[i]);
        }

        for (int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;
            pq.offer(sum);
            pq.offer(sum);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);

    }
}
