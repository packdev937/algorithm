package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _15681 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] cnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        cnt = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(R);
        for (int i = 0; i < Q; i++) {
            int find = Integer.parseInt(br.readLine());
            System.out.println(cnt[find]);
        }
    }

    public static void dfs(int R) {
        cnt[R] = 1;
        visited[R] = true;
        for (int child : graph.get(R)) {
            if (!visited[child]) {
                dfs(child);
                cnt[R] += cnt[child];
            }
        }
    }
}
