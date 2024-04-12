package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()),
	Integer.parseInt(st.nextToken()));
            Point[] marts = new Point[N];
            boolean[] visited = new boolean[N];
            for (int j = 0; j < N; j++) {
	st = new StringTokenizer(br.readLine());
	Point mart = new Point(Integer.parseInt(st.nextToken()),
	    Integer.parseInt(st.nextToken()));
	marts[j] = mart;
            }
            st = new StringTokenizer(br.readLine());
            Point festival = new Point(Integer.parseInt(st.nextToken()),
	Integer.parseInt(st.nextToken()));

            bfs(start, marts, visited, festival);
        }
    }

    private static void bfs(Point start, Point[] marts, boolean[] visited, Point festival) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            Point temp = queue.poll();
            if(temp.isArrivable(festival)){
	System.out.println("happy");
	return;
            }
            for (int i = 0; i < marts.length; i++) {
	if(!visited[i] && marts[i].isArrivable(temp)){
	    visited[i] = true;
	    queue.add(marts[i]);
	}
            }
        }
        System.out.println("sad");
        return;
    }

    static class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isArrivable(Point p) {
            return (Math.abs(this.x - p.x) + Math.abs(this.y - p.y)) <= 1000;
        }
    }
}
