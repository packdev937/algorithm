package baekjoon.graph;

import java.io.*;
import java.util.*;

public class _4485 {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int problemNumber = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] board = new int[N][N];
            for (int i = 0; i < N; i++) {
	StringTokenizer st = new StringTokenizer(br.readLine());
	for (int j = 0; j < N; j++) {
	    board[i][j] = Integer.parseInt(st.nextToken());
	}
            }

            int result = dijkstra(N, board);
            System.out.print("Problem " + problemNumber + ": " + result + "\n");
            problemNumber++;
        }
    }

    private static int dijkstra(int N, int[][] board) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        int[][] costs = new int[N][N];
        for (int[] row : costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        pq.offer(new Node(0, 0, board[0][0]));
        costs[0][0] = board[0][0];

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.x == N - 1 && current.y == N - 1) {
	return current.cost;
            }
            for (int i = 0; i < 4; i++) {
	int nx = current.x + dx[i];
	int ny = current.y + dy[i];
	if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
	    int newCost = current.cost + board[nx][ny];
	    if (newCost < costs[nx][ny]) {
	        costs[nx][ny] = newCost;
	        pq.offer(new Node(nx, ny, newCost));
	    }
	}
            }
        }
        return -1;
    }

    static class Node {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
