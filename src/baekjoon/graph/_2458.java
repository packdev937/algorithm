package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2458 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            reverseGraph.get(b).add(a);
        }

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (bfs(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean bfs(int i) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int next : graph.get(temp)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }

        queue.add(i);
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int next : reverseGraph.get(temp)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        // visited 배열을 다 돌았으면 True -> 메모리 초과
        return count == N;
    }
}
