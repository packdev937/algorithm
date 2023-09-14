package baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2623 {

    static int[] in_degree;
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        in_degree = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j < s.length; j++) {
                for (int k = j + 1; k < s.length; k++) {
                    graph.get(Integer.parseInt(s[j])).add(Integer.parseInt(s[k]));
                    in_degree[Integer.parseInt(s[k])]++;
                }
            }
        }

        for (int i = 1; i < in_degree.length; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            bw.write(temp + "\n");
            cnt++;
            for (int i = 0; i < graph.get(temp).size(); i++) {
                int n = graph.get(temp).get(i);
                in_degree[n]--;
                if (in_degree[n] == 0) {
                    queue.add(n);
                }
            }
        }

        if (cnt == N) {
            bw.flush();
        } else {
            System.out.print(0);
        }
    }
}
