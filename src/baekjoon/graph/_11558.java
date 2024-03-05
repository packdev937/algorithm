package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _11558 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> graph = new ArrayList<>();
            for (int j = 0; j < N; j++) {
	graph.add(Integer.parseInt(br.readLine()));
            }

            boolean[] visited = new boolean[N]; // 방문 여부 확인을 위한 배열
            int cnt = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0); // 첫 번째 노드의 인덱스 추가
            visited[0] = true; // 첫 번째 노드를 방문한 것으로 표시

            while (!queue.isEmpty()) {
	int node = queue.poll();
	int nextNode = graph.get(node) - 1; // 다음 노드의 인덱스 (0부터 시작)

	cnt++;
	if (nextNode == N - 1) { // 마지막 노드에 도달했는지 확인
	    break;
	}
	if (!visited[nextNode]) {
	    queue.add(nextNode);
	    visited[nextNode] = true;
	} else {
	    cnt = -1; // 이미 방문한 노드를 다시 방문하려고 한 경우, 루프에 빠진 것으로 간주
	    break;
	}
            }

            if (cnt == -1) {
	System.out.println("0");
            } else {
	System.out.println(cnt);
            }
        }
    }
}
