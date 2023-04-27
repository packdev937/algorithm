package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260 {
    static boolean[] ch;
    static int[][] graph;
    static Queue<Integer> Q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int V) {
        ch[V] = true;
        sb.append(V + " ");
        for (int i = 1; i < graph[V].length; i++) {
            if (graph[V][i] == 1 && ch[i] != true) {
                DFS(i);
            }
        }
    }

    public static void BFS(int V) {
        Q.add(V);
        ch[V] = true;

        while (!Q.isEmpty()) {
            int temp = Q.poll();
            sb.append(temp + " ");
            for (int i = 1; i < graph[temp].length; i++) {
                if (graph[temp][i] == 1 && ch[i] != true) {
                    Q.add(i);
                    ch[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        ch = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        // Executing DFS
        DFS(V);
        ch = new boolean[N + 1];
        sb.append("\n");
        // Executing BFS
        BFS(V);

        System.out.print(sb);
    }
}
