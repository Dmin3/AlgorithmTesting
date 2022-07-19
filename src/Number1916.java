import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Number1916 {
    static int n, m;
    static ArrayList<ArrayList<City>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cityNum1 = Integer.parseInt(st.nextToken());
            int cityNum2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(cityNum1).add(new City(cityNum2, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist[start] = 0;

        dijkstra(start);

        System.out.println(dist[end]);

    }

    private static void dijkstra(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            City now_city = pq.poll();

            if (visited[now_city.cityNum]) continue;

            visited[now_city.cityNum] = true;

            for (int i = 0; i < graph.get(now_city.cityNum).size(); i++) {
                City next_city = graph.get(now_city.cityNum).get(i);
                if (!visited[next_city.cityNum] && dist[next_city.cityNum] > dist[now_city.cityNum] + next_city.cost) {
                    dist[next_city.cityNum] = dist[now_city.cityNum] + next_city.cost;
                    pq.offer(new City(next_city.cityNum, dist[next_city.cityNum]));
                }
            }
        }
    }

    static class City implements Comparable<City> {
        int cityNum;
        int cost;

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
