package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _2056 {

    static int[] in_degree, time, ori;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        in_degree = new int[N + 1];
        time = new int[N + 1];
        ori = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            time[i] = Integer.parseInt(s[0]);
            ori[i] = Integer.parseInt(s[0]);
            if (s.length == 2) {
                in_degree[i] = 0;
            } else {
                in_degree[i] = s.length - 2;
                for (int j = 2; j < s.length; j++) {
                    graph.get(Integer.parseInt(s[j])).add(i);
                }
            }
        }

        for (int i = 1; i < in_degree.length; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i < graph.get(temp).size(); i++) {
                int n = graph.get(temp).get(i);
                in_degree[n]--;
                time[n] = Math.max(time[n], time[temp] + ori[n]);
                if (in_degree[n] == 0) {
                    queue.add(n);
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i < time.length; i++) {
            answer = Math.max(answer, time[i]);
        }
        System.out.print(answer);
    }

}
