package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2636 {

    static int[][] board;
    static boolean[][] ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static final int air = 99999;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        ch = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
	board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hour = 0;
        int lastCheese = 0;
        while (!isBoardEmpty()) {
            hour++;
            makeAir();
            int cnt = meltCheese();
            if (cnt > 0) {
	lastCheese = cnt;
            }
        }
        System.out.println(hour);
        System.out.println(lastCheese);
    }

    public static void makeAir() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        // 판의 가장자리에서 BFS 시작
        for (int i = 0; i < N; i++) {
            if (!visited[i][0]) {
	q.add(new int[]{i, 0});
	visited[i][0] = true;
            }
            if (!visited[i][M - 1]) {
	q.add(new int[]{i, M - 1});
	visited[i][M - 1] = true;
            }
        }
        for (int j = 0; j < M; j++) {
            if (!visited[0][j]) {
	q.add(new int[]{0, j});
	visited[0][j] = true;
            }
            if (!visited[N - 1][j]) {
	q.add(new int[]{N - 1, j});
	visited[N - 1][j] = true;
            }
        }

        // BFS를 사용하여 공기 영역 탐색
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];
            board[y][x] = air; // 현재 위치를 공기로 표시

            for (int i = 0; i < 4; i++) {
	int ny = y + dy[i];
	int nx = x + dx[i];

	// 판 범위 내에 있고, 방문하지 않았으며, 치즈가 아닌 경우
	if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx]
	    && board[ny][nx] != 1) {
	    q.add(new int[]{ny, nx});
	    visited[ny][nx] = true;
	}
            }
        }
    }


    public static int meltCheese() {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
	if (board[i][j] == 1 && isExposedToAir(i, j)) {
	    q.add(new int[]{i, j});
	}
            }
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            board[temp[0]][temp[1]] = air;
            cnt++;
        }

        return cnt;
    }

    public static boolean isExposedToAir(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N && board[ny][nx] == air) {
	return true;
            }
        }
        return false;
    }

    public static boolean isBoardEmpty() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
	if (board[i][j] == 1) {
	    return false;
	}
            }
        }
        return true;
    }
}
