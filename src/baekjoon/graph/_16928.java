package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16928 {

    static HashMap<Integer, Integer> ride = new HashMap<>();
    static boolean[] visited = new boolean[101]; // 방문 여부 체크 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ride.put(a, b);
        }

        int start = 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[0] == 100) {
                System.out.println(temp[1]);
                return;
            }
            int nextPos;
            if (ride.containsKey(temp[0])) {
                nextPos = ride.get(temp[0]);
                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.add(new int[]{nextPos, temp[1]});
                }
            }
            for (int i = 1; i < 7; i++) {
                nextPos = temp[0] + i;
                if (nextPos > 100) {
                    continue;
                }
                if (visited[nextPos]) {
                    continue;
                }
                if (ride.containsKey(nextPos)) {
                    nextPos = ride.get(nextPos);
                    if (!visited[nextPos]) {
                        visited[nextPos] = true;
                        queue.add(new int[]{nextPos, temp[1]+1});
                    }
                }
                visited[nextPos] = true;
                queue.add(new int[]{nextPos, temp[1] + 1});
            }
        }
    }
}
