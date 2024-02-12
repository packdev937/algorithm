package baekjoon.graph.bellman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {

    int end;
    int weight;

    Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class _1865_1 {

    static int N, M, W;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> graph;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
	graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M + W; i++) {
	st = new StringTokenizer(br.readLine());
	int start = Integer.parseInt(st.nextToken());
	int end = Integer.parseInt(st.nextToken());
	int weight = Integer.parseInt(st.nextToken());

	if (i < M) {
	    graph.get(start).add(new Edge(end, weight));
	    graph.get(end).add(new Edge(start, weight));
	} else {
	    graph.get(start).add(new Edge(end, -weight));
	}
            }

            sb.append(bellmanFord() ? "YES\n" : "NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j <= N; j++) {
	for (Edge edge : graph.get(j)) {
	    if (dist[edge.end] > dist[j] + edge.weight) {
	        dist[edge.end] = dist[j] + edge.weight;
	        update = true;
	    }
	}
            }

            if (!update) {
	break;
            }
        }

        if (update) {
            for (int i = 1; i <= N; i++) {
	for (Edge edge : graph.get(i)) {
	    if (dist[edge.end] > dist[i] + edge.weight) {
	        return true;
	    }
	}
            }
        }
        return false;
    }
}
