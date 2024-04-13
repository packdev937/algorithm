package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _21736 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static char[][] board;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
	board[i][j] = input.charAt(j);
	if (board[i][j] == 'I') {
	    queue.add(new int[]{i, j});
	    visited[i][j] = true;  // Mark the initial position as visited
	}
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
	int ny = y + dy[i];
	int nx = x + dx[i];
	if (nx >= 0 && ny >= 0 && ny < N && nx < M) {
	    if (visited[ny][nx]) {  // Correct the visited array check
	        continue;
	    }
	    if (board[ny][nx] != 'X') {
	        visited[ny][nx] = true;  // Mark as visited when enqueued
	        queue.add(new int[]{ny, nx});
	        if (board[ny][nx] == 'P') {
	            answer++;
	        }
	    }
	}
            }
        }

        System.out.println(answer == 0 ? "TT" : answer);
    }
}
