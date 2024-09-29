package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15685 {

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static boolean[][] board = new boolean[101][101];

    private static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());

            drawDragonCurve(x, y, direction, generation);
        }

        System.out.println(countSquares());
    }

    public static void drawDragonCurve(int x, int y, int direction, int generation) {
        List<Integer> directions = new ArrayList<>();
        directions.add(direction);

        board[y][x] = true;

        // 첫 번째 지점 설정
        int ny = y + dy[direction];
        int nx = x + dx[direction];
        board[ny][nx] = true;

        // 세대에 따라 드래곤 커브의 방향을 계산
        for (int g = 1; g <= generation; g++) {
            int size = directions.size();
            for (int j = size - 1; j >= 0; j--) {
	int nextDirection = (directions.get(j) + 1) % 4; // 90도 회전
	ny += dy[nextDirection];
	nx += dx[nextDirection];
	board[ny][nx] = true;
	directions.add(nextDirection);
            }
        }
    }

    public static int countSquares() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
	if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) {
	    count++;
	}
            }
        }
        return count;
    }
}
