package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1068 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] parent;
    static Integer answer = 0, root = 0, deletedNode = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == -1) {
                root = i;
                continue;
            }
            graph.get(input).add(i);
            parent[i] = input;
        }
        deletedNode = Integer.parseInt(br.readLine());
        graph.get(parent[deletedNode]).remove(deletedNode);

        dfs(root);
        System.out.println(answer);
    }

    public static void dfs(int node) {
        if (node == deletedNode) {
            return;
        }
        if (graph.get(node).size() == 0) {
            answer++;
        }
        for (int i = 0; i < graph.get(node).size(); i++) {
            dfs(graph.get(node).get(i));
        }
    }
}
