package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _24445 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점의 수
        int N = Integer.parseInt(st.nextToken());
        // 간선의 수
        int M = Integer.parseInt(st.nextToken());
        // 시작 정점
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // pain point (1) N이 아닌 간선의 개수 M 만큼
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 매핑
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // pain point (2) 각 정점의 연결리스트를 내림차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        // BFS 시작
        queue.add(R);
        visited[R] = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 0; i < graph.get(temp).size(); i++) {
	int next = graph.get(temp).get(i);
	// 방문하지 않았다면
	if (visited[next] == 0) {
	    visited[next] = ++count;
	    queue.add(next);
	}
            }
        }

        // 출력
        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }
}
