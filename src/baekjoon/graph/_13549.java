package baekjoon.graph;

import java.util.*;

public class _13549 {
    static int[] time = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수빈이의 위치
        int K = sc.nextInt(); // 동생의 위치
        bfs(N, K);

        System.out.println(time[K]);
    }

    public static void bfs(int N, int K) {
        Arrays.fill(time, -1); // time 배열 초기화
        Arrays.fill(visited, false); // visited 배열 초기화

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;
        time[N] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();

            if (temp == K) {
                return;
            }

            int[] next = {temp * 2, temp - 1, temp + 1}; // 순간이동을 먼저 시도하기 위해 순서 변경

            for (int i = 0; i < 3; i++) {
                if (next[i] >= 0 && next[i] <= 100000 && !visited[next[i]]) {
                    q.add(next[i]);
                    visited[next[i]] = true;
                    if (i == 0) {
                        time[next[i]] = time[temp]; // 순간이동인 경우 시간 증가 없음
                    } else {
                        time[next[i]] = time[temp] + 1;
                    }
                }
            }
        }
    }
}
