package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1197 {
    static public ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // ArrayList를 중첩으로 써 graph를 구현
        // 가중치는 어떻게 표현할까?
        // 가중치가 있는 경우 (정점, 가중치) 를 같이 표현할 수 있는 자료 구조를 활용하면 됨
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(c, b));
        }
    }

    // Nested Class
    // Nested Class 를 사용하는 가장 큰 이유는 소스의 가독성을 높이고 유지보수를 용이하게 하기 위함
    private static class Node {
        private int vertex;
        private int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
