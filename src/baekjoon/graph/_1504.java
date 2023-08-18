package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1504 {

    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int N, E;
    static final int INF = 200000000;

    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        // 반드시 지나야 하는 정점
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int sum1 = 0;
        sum1 += dijkstra(1, u);
        sum1 += dijkstra(u, v);
        sum1 += dijkstra(v, N);

        int sum2 = 0;
        sum2 += dijkstra(1, v);
        sum2 += dijkstra(v, u);
        sum2 += dijkstra(u, N);

        System.out.println((sum1 >= INF && sum2 >= INF) ? -1 : Math.min(sum1, sum2));
    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            visited[temp[0]] = true;

            for (int i = 0; i < graph.get(temp[0]).size(); i++) {
                if (!visited[graph.get(temp[0]).get(i)[0]]) {
                    if (dist[graph.get(temp[0]).get(i)[0]] > dist[temp[0]] + graph.get(temp[0])
                        .get(i)[1]) {
                        dist[graph.get(temp[0]).get(i)[0]] =
                            dist[temp[0]] + graph.get(temp[0]).get(i)[1];
                        pq.add(new int[]{graph.get(temp[0]).get(i)[0],
                            dist[graph.get(temp[0]).get(i)[0]]});
                    }
                }
            }
        }

        return dist[end];
    }
}
