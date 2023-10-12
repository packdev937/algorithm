package baekjoon.graph.kruskal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1922 {

    static class Edge implements Comparable<Edge> {

        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    static int[] parent;
    static ArrayList<Edge> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Edge(a, b, c));
        }

        // parent를 자기 자신으로 초기화 했었지
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 가중치가 작은 것 부터 정렬해야지
        Collections.sort(graph);

        int answer = 0;
        // parent를 통일함으로써 후에 큰 가중치의 값이 들어왔을 때 이미 연결되었다는 걸 확인하고 연결 하지 않는다
        for (int i = 0; i < graph.size(); i++) {
            Edge edge = graph.get(i);

            // 만약에 둘의 parent가 다르면
            if (find(edge.start) != find(edge.end)) {
                // answer에 추가하고
                answer += edge.weight;

                // parent를 합쳐줌
                union(edge.start, edge.end);
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int x) {
        // 만약에 parent이 자기 자신이면 x를 리턴하고
        if (x == parent[x]) {
            return x;
        }
        // 아니면 parent[x] = 상위 parent으로
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        // parent를 찾고
        x = find(x);
        y = find(y);

        // parent를 통일
        if (x != y) {
            parent[y] = x;
        }
    }
}
