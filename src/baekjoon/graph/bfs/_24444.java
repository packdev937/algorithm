package baekjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _24444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        int[] count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 모든 노드에 대해 한 번에 정렬
        for (ArrayList<Integer> neighbours : graph) {
            Collections.sort(neighbours);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        visited[R] = true; // 시작점 방문 표시
        int cnt = 1;
        count[R] = cnt++;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int next : graph.get(temp)) {
	if (!visited[next]) {
	    visited[next] = true;
	    queue.add(next);
	    count[next] = cnt++;
	}
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write(count[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
