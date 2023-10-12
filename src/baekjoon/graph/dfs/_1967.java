package baekjoon.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1967 {

    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int maxWeight = Integer.MIN_VALUE;
    static int maxNodeNumber = 1;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        // 첫 번째 DFS
        visited = new boolean[N + 1];
        dfs(1, 0);

        // 두 번째 DFS
        visited = new boolean[N + 1];
        maxWeight = Integer.MIN_VALUE;
        dfs(maxNodeNumber, 0);

        System.out.println(maxWeight);

        // 가장 긴 노드의 길이를 찾으려면 DFS를 두 번 돌아야 한다
        // 첫 번째에서는 루트에서 가장 긴 길이
        // 두 번째애세는 해당 긴 길이에서 다른 긴 길이
    }

    public static void dfs(int i, int weight) {
        if (visited[i]) {
            return;
        } else {
            visited[i] = true;
        }

        if (weight > maxWeight) {
            maxWeight = weight;
            maxNodeNumber = i;
        }

        for (int j = 0; j < graph.get(i).size(); j++) {
            dfs(graph.get(i).get(j)[0], weight + graph.get(i).get(j)[1]);
        }
    }
}