package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1504 {

    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 출발 위치
            int A = Integer.parseInt(st.nextToken()); // 도착 위치
            int W = Integer.parseInt(st.nextToken()); // 지름길의 길이

            if (A > D) {
                continue; // 도착 위치가 도로의 길이를 넘어서는 경우
            }
            if (A - S < W) {
                continue; // 지름길이 아닌 경우
            }
            pq.add(new int[]{S, A, W});
        }

        int curr = 0;
        while (true) {
            if (curr == D) {
                break;
            }
            while (!pq.isEmpty()) {
                if (curr == pq.peek()[0]) {
                    dist[pq.peek()[1]] = Math.min(dist[pq.peek()[1]], dist[curr] + pq.peek()[2]);
                    pq.poll();
                } else {
                    dist[curr + 1] = Math.min(dist[curr + 1], dist[curr] + 1);
                    curr++;
                }
            }
            dist[curr + 1] = Math.min(dist[curr + 1], dist[curr] + 1);
            curr++;
        }
        System.out.print(dist[D]);
    }
}
