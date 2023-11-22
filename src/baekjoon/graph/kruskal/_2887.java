package baekjoon.graph.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2887 {

    static int[] parent;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N];

        parent = new int[N];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < points.length; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            points[i] = new Point(i, x, y, z);
        }

        Arrays.sort(points, (o1, o2) -> o1.x - o2.x);
        for (int i = 0; i < N - 1; i++) {
            pq.add(new Node(points[i].idx, points[i + 1].idx,
	Math.abs(points[i].x - points[i + 1].x)));
        }

        Arrays.sort(points, (o1, o2) -> o1.y - o2.y);
        for (int i = 0; i < N - 1; i++) {
            pq.add(new Node(points[i].idx, points[i + 1].idx,
	Math.abs(points[i].y - points[i + 1].y)));
        }

        Arrays.sort(points, (o1, o2) -> o1.z - o2.z);
        for (int i = 0; i < N - 1; i++) {
            pq.add(new Node(points[i].idx, points[i + 1].idx,
	Math.abs(points[i].z - points[i + 1].z)));
        }
        int answer = 0;
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            if (find(temp.from) != find(temp.to)) {
	union(temp.from, temp.to);
	answer += temp.weight;
            }
        }

        System.out.println(answer);
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    static class Point {

        int idx;
        int x;
        int y;
        int z;

        public Point(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Node {

        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
