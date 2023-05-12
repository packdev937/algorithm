package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 위상 정렬을 이용해야 한다
public class _1766 {

    static int N, M;

    // graph 형태 -> 예를 들어 3 다음에 5
    static List<Integer>[] adj;

    // 차수를 표현할 배열
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 각각의 노드 마다 그래프를 만들어 준다
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        indegree = new int[N + 1];

        // a <- b의 형태
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            indegree[b]++;
        }

        // 차수가 0인것만 큐에 저장한다
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        // 큐가 빌 때 까지 빼는데, 해당 큐 값이 자식들을 가지고 있다면 자식들의 차수는 하나씩 감소한다
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            for (int next : adj[curr]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}

