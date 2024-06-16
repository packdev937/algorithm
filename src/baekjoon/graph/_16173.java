package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16173 {

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int[][] board;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
	board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new int[]{0, 0});
        // Pain Point Visited를 기록하지 않음
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int y = temp[0];
            int x = temp[1];

            if (board[y][x] == -1) {
	System.out.print("HaruHaru");
	return;
            }

            for (int i = 0; i < dx.length; i++) {
	// Pain Point -1 씩 이동 기회를 차감하려고 했음
	int ny = y + dy[i] * board[y][x];
	int nx = x + dx[i] * board[y][x];

	if (ny >= 0 && nx >= 0 && ny < board.length && nx < board.length && !visited[ny][nx]) {
	    queue.add(new int[]{ny, nx});
	    visited[ny][nx] = true;
	}
            }
        }

        System.out.print("Hing");
    }
}
