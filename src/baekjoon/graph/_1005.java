package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1005 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] in_degree, time, ori;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            // 건물의 개수
            int N = Integer.parseInt(st.nextToken());
            // 건물 순서 규칙
            int K = Integer.parseInt(st.nextToken());
            // 건물의 시간
            time = new int[N + 1];
            ori = new int[N + 1];
            in_degree = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                int t = Integer.parseInt(st.nextToken());
                time[j] = t;
                ori[j] = t;
            }

            // 건설 순서
            graph.clear();
            for (int j = 0; j < N + 1; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                in_degree[b]++;
            }
            int target = Integer.parseInt(br.readLine());

            // 시작
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 1; j < in_degree.length; j++) {
                if (in_degree[j] == 0) {
                    queue.add(j);
                }
            }

            while (!queue.isEmpty()) {
                int temp = queue.poll();
                for (int j = 0; j < graph.get(temp).size(); j++) {
                    int num = graph.get(temp).get(j);
                    time[num] = Math.max(time[num], time[temp] + ori[num]);
                    in_degree[num]--;

                    if (in_degree[num] == 0) {
                        queue.add(num);
                    }
                }
            }
            System.out.println(time[target]);
        }
    }
}