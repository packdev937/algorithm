package baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1325 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
        }

        result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            result[i] = bfs(i);
        }

        int maxCount = Arrays.stream(result).max().getAsInt();
        for (int i = 1; i < result.length; i++) {
            if(result[i] == maxCount) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int index) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        int answer = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i : graph.get(x)) {
	if (!visited[i]) {
	    visited[i] = true;
	    queue.offer(i);
                    answer++;
	}
            }
        }
        return answer;
    }

//    public static int getSize(int index) {
//        int answer = graph.get(index).size();
//        if (graph.get(index).isEmpty()) {
//            return 1;
//        }
//        for (int j : graph.get(index)) {
//            answer += getSize(j);
//        }
//        return answer;
//    }
}
