import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Number18352 {
    static int n, m, k, x;
    static ArrayList<ArrayList<City>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(new City(y, 1));
        }

        dijkstra(x);

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == k) {
                sb.append(i).append("\n");
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }

    public static void dijkstra(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            City city = pq.poll();
            int num = city.cityNum;

            if (visited[num]) continue;

            visited[num] = true;

            for (City c : graph.get(num)) {
                if (!visited[c.cityNum] && dist[c.cityNum] > (c.cost + dist[num])) {
                    dist[c.cityNum] = c.cost + dist[num];
                    pq.offer(new City(c.cityNum, dist[c.cityNum]));
                }
            }
        }
    }

    static class City implements Comparable<City> {
        public int cityNum;
        public int cost;

        public City(int cityNum, int cost) {
            this.cityNum = cityNum;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return cost - o.cost;
        }
    }
}
