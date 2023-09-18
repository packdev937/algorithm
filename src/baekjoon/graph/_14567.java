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

public class _14567 {

    static int[] in_degree, answer;
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        in_degree = new int[N + 1];
        answer = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            in_degree[b]++;
        }

        for (int i = 1; i < in_degree.length; i++) {
            if (in_degree[i] == 0) {
                queue.add(new int[]{i, 1});
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            answer[temp[0]] = temp[1];
            for (int i = 0; i < graph.get(temp[0]).size(); i++) {
                int num = graph.get(temp[0]).get(i);
                in_degree[num]--;
                if (in_degree[num] == 0) {
                    queue.add(new int[]{num, temp[1] + 1});
                }
            }
        }

        for (int i = 1; i < answer.length; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
