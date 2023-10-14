package baekjoon.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _5567 {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] ch;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ch = new boolean[N + 1];
        dfs(1, 0);
        for (int i = 2; i < ch.length; i++) {
            if (ch[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int start, int depth) {
        if (depth >= 2) {
            return;
        }
        for (int next : graph.get(start)) {
            ch[next] = true;
            dfs(next, depth + 1);
        }
    }
}
