package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _1976 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cities = new int[M];
        for (int i = 0; i < M; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < cities.length - 1; i++) {
            if (!bfs(cities[i]-1, cities[i + 1]-1)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        return;
    }

    public static boolean bfs(int start, int end) {
        boolean[] visited = new boolean[N];

        // Initialization
        queue.clear();
        queue.add(start);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp == end) {
                return true;
            }
            if (visited[temp]) {
                continue;
            }
            visited[temp] = true;
            for (int i = 0; i < graph.get(temp).size(); i++) {
                int n = graph.get(temp).get(i);
                if (!visited[n]) {
                    queue.add(n);
                }
            }
        }
        return false;
    }
}
