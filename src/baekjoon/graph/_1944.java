package baekjoon.graph;

import java.io.*;
import java.util.*;

public class _1944 {

    static ArrayList<Node> list;
    static int N, M;
    static char[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static PriorityQueue<Mst_Node> pq;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
	char c = input.charAt(j);
	board[i][j] = c;
	if (c == 'S' || c == 'K') {
	    list.add(new Node(i, j, 0));
	}
            }
        }

        pq = new PriorityQueue<Mst_Node>();
        for (int i = 0; i < M + 1; i++) {
            bfs(i);
        }
        System.out.println(kruskal());
    }

    public static int kruskal() {
        parent = new int[M + 1];
        for (int i = 0; i < M + 1; i++) {
            parent[i] = i;
        }

        int cost = 0;
        int edge_count = 0;
        while (!pq.isEmpty()) {
            Mst_Node current = pq.poll();

            int p1 = find(current.s);
            int p2 = find(current.e);

            if (p1 != p2) {
	union(p1, p2);
	cost += current.cost;
	edge_count++;
            }
        }
        if (edge_count != M) {
            return -1;
        }
        return cost;
    }

    public static void union(int p1, int p2) {
        parent[p1] = p2;
    }

    public static int find(int node) {
        if (parent[node] == node) {
            return node;
        } else {
            return parent[node] = find(parent[node]);
        }
    }

    public static void bfs(int num) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(list.get(num));
        visited[list.get(num).x][list.get(num).y] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (int i = 0; i < 4; i++) {
	int nx = current.x + dx[i];
	int ny = current.y + dy[i];

	if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
	    continue;
	}
	if (board[nx][ny] == '1' || visited[nx][ny]) {
	    continue;
	}
	visited[nx][ny] = true;

	if (board[nx][ny] == 'S' || board[nx][ny] == 'K') {
	    for (int j = 0; j < M + 1; j++) {
	        if (list.get(j).x == nx && list.get(j).y == ny) {
	            pq.offer(new Mst_Node(num, j, current.count + 1));
	        }
	    }
	}
	q.offer(new Node(nx, ny, current.count + 1));
            }
        }
    }

    public static class Mst_Node implements Comparable<Mst_Node> {

        int s, e, cost;

        public Mst_Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Mst_Node n) {
            return this.cost - n.cost;
        }
    }

    public static class Node {

        int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
