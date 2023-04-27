package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1389 {
    static int[][] ch;
    static int N, M, minNum, min = 9999;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            BFS(i + 1);
        }

        System.out.println(minNum);
    }

    public static void BFS(int i) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(i);
        int num = 0;
        int cnt = 0;
        while (!Q.isEmpty()) {
            int temp = Q.poll();
            ch[i][temp] = 1;
            cnt++;
            for (int j = 0; j < graph.get(temp).size(); j++) {
                int n = graph.get(temp).get(j);
                if (ch[i][n] != 1) {
                    Q.add(n);
                    num += cnt;
                }
            }
        }
        System.out.println(i + "," + num);
        if (num < min) {
            min = num;
            minNum = i;
        } else if (num == min) {
            if (minNum > i)
                minNum = i;
        }
    }
}
