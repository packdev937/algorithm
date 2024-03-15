package programmers.lv2;

import java.util.ArrayList;

public class 도넛과_막대_그래프 {

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    int[] incomingEdges;

    public int[] solution(int[][] edges) {

        init(edges);
        int startVertex = findStartNode();

        for (int i = 0; i < graph.get(startVertex).size(); i++) {
            incomingEdges[graph.get(startVertex).get(i)]--;
        }

        int graphCount = graph.get(startVertex).size();
        int barCount = calculateBarCount(startVertex);
        int eightCount = calculateEightCount();
        int cycleCount = graphCount - (barCount + eightCount);

        return new int[]{startVertex, cycleCount, barCount, eightCount};
    }

    private int calculateEightCount() {
        int eightCount = 0;
        for (int i = 1; i < incomingEdges.length; i++) {
            if (graph.get(i).size() == 2 && incomingEdges[i] == 2 && !visited[i]) {
	eightCount++;
	visited[i] = true;
            }
        }
        return eightCount;
    }

    private int calculateBarCount(int startVertex) {
        int barCount = 0;
        for (int i = 1; i < incomingEdges.length; i++) {
            if (i == startVertex) {
                continue;
            }
            if (graph.get(i).isEmpty() && !visited[i]) {
	barCount++;
	visited[i] = true;
            }
        }
        return barCount;
    }

    private void init(int[][] edges) {
        int edgeCount = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            edgeCount = Math.max(edgeCount, Math.max(edge[0], edge[1]));
        }
        visited = new boolean[edgeCount + 1];
        incomingEdges = new int[edgeCount + 1];

        for (int i = 0; i <= edgeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).add(b);
            incomingEdges[b]++;
        }
    }

    private int findStartNode() {
        int startVertex = -1;
        for (int i = 1; i < incomingEdges.length; i++) {
            if (graph.get(i).size() >= 2 && incomingEdges[i] == 0) {
	startVertex = i;
	break;
            }
        }
        visited[startVertex] = true;
        return startVertex;
    }


    public static void main(String[] args) {
        도넛과_막대_그래프 s = new 도넛과_막대_그래프();
        int[][] edges = {
            {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6},
            {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
        };
        System.out.println(s.solution(edges));
    }
}
