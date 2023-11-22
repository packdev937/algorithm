package baekjoon.graph.kruskal;

import java.io.*;
import java.util.*;

public class _4792 {

    private static final int IMPOSSIBLE = -1;

    static class Edge {

        int from, to;
        boolean isBlue;

        Edge(int from, int to, boolean isBlue) {
            this.from = from;
            this.to = to;
            this.isBlue = isBlue;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0 && k == 0) {
	break;
            }

            List<Edge> edges = new ArrayList<>();
            parent = new int[n + 1];
            for (int i = 0; i < m; i++) {
	st = new StringTokenizer(br.readLine());
	char color = st.nextToken().charAt(0);
	int f = Integer.parseInt(st.nextToken());
	int t = Integer.parseInt(st.nextToken());

	edges.add(new Edge(f, t, color == 'B'));
            }
            int bmax = maximumBlueTree(edges, n);
            int bmin = maximumRedTree(edges, n);

            if (bmax == IMPOSSIBLE || bmin == IMPOSSIBLE) {
	System.out.println(0);
	continue;
            }
            if (bmin <= k && k <= bmax) {
	System.out.println(1);
	continue;
            }
            System.out.println(0);
        }
    }

    private static int maximumRedTree(List<Edge> edges, int n) {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int blueCount = 0;
        int redCount = 0;
        for (Edge edge : edges) {
            if (!edge.isBlue && union(edge.from, edge.to)) {
	redCount++;
            }
        }

        for (Edge edge : edges) {
            if (edge.isBlue && union(edge.from, edge.to)) {
	blueCount++;
            }
        }

        if (blueCount + redCount == n - 1) {
            return blueCount;
        }
        return IMPOSSIBLE;
    }

    static int maximumBlueTree(List<Edge> edges, int n) {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int blueCount = 0;
        int redCount = 0;
        for (Edge edge : edges) {
            if (edge.isBlue && union(edge.from, edge.to)) {
	blueCount++;
            }
        }

        for (Edge edge : edges) {
            if (!edge.isBlue && union(edge.from, edge.to)) {
	redCount++;
            }
        }

        if (blueCount + redCount == n - 1) {
            return blueCount;
        }
        return IMPOSSIBLE;
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        parent[y] = x;
        return true;
    }
}
