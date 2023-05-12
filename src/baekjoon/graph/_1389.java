package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1389 {
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minBacon = Integer.MAX_VALUE;
        int minPerson = 0;

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            int bacon = calculateBacon(i, N);
            if (bacon < minBacon) {
                minBacon = bacon;
                minPerson = i;
            }
        }

        System.out.println(minPerson);
    }

    public static int calculateBacon(int start, int N) {
        boolean[] visited = new boolean[N + 1];
        int[] bacon = new int[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    bacon[neighbor] = bacon[current] + 1;
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += bacon[i];
        }
        return sum;
    }
}
