package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1707 {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            group = new int[V + 1];
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean isBipartite = true;
            for (int j = 1; j <= V; j++) {
                if (group[j] == 0) {
                    isBipartite = bfs(j);
                    if (!isBipartite) break;
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    public static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        group[start] = 1;  // 1 또는 -1로 그룹 지정

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int adjacent : graph.get(currentNode)) {
                if (group[adjacent] == 0) {
                    group[adjacent] = -group[currentNode];
                    queue.add(adjacent);
                } else if (group[adjacent] == group[currentNode]) {
                    return false;
                }
            }
        }
        return true;
    }
}
