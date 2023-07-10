package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _18352 {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // Initialization
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] ch = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, 1));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(new Node(X, 0));
            while (!pq.isEmpty()) {
                Node temp = pq.poll();
                int index = temp.node;
                if (ch[index]) {
                    continue;
                }
                ch[index] = true;
                for (Node n : graph.get(index)) {
                    if (!ch[n.node] && n.weight + dist[index] < dist[n.node]) {
                        dist[n.node] = n.weight + dist[index];
                        pq.offer(new Node(n.node, dist[n.node]));
                    }
                }
            }
        }
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == K) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    static class Node implements Comparable<Node> {

        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
