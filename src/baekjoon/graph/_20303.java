package baekjoon.graph;

import java.io.*;
import java.util.*;

public class _20303 {

    static int N, M, K;
    static int[] candy, group, parent;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candy = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        group = new int[N + 1];
        Arrays.fill(group, 1);

        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        makeGroup();

        System.out.println(dp());
    }

    private static long dp() {
        long[][] dp = new long[list.size() + 1][K];

        for (int i = 1; i < list.size() + 1; i++) {
            int cost = list.get(i - 1).cost;
            long value = list.get(i - 1).value;

            for (int j = 0; j < K; j++) {
                if (cost <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[list.size()][K - 1];
    }

    private static void makeGroup() {
        for (int i = 1; i < N + 1; i++) {
            if (parent[i] != i) {
                int p = find(i);
                candy[p] += candy[i];
                group[p] += group[i];
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (parent[i] == i) {
                list.add(new Node(group[i], candy[i]));
            }
        }
    }

    private static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static class Node {

        int cost;
        long value;

        public Node(int cost, long value) {
            this.cost = cost;
            this.value = value;
        }
    }
}