package baekjoon.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15684 {

    static int N, M, H, min = Integer.MAX_VALUE;
    static boolean[][] ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        backTracking(1, 0);
        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void backTracking(int x, int count) {
        if (count >= min) return; // 가지치기: 현재 사다리 개수가 이미 최소값 이상이면 더 이상 진행하지 않음

        if (execute()) {
            min = count;
            return;
        }

        if (count == 3) return; // 사다리 최대 3개까지만 허용

        for (int i = x; i <= H; i++) {
            for (int j = 1; j < N; j++) {
	if (!ladder[i][j] && !ladder[i][j - 1] && !ladder[i][j + 1]) {
	    ladder[i][j] = true;
	    backTracking(i, count + 1);
	    ladder[i][j] = false;
	}
            }
        }
    }

    public static boolean execute() {
        for (int i = 1; i <= N; i++) {
            int col = i;
            for (int row = 1; row <= H; row++) {
	if (ladder[row][col]) col++;
	else if (col > 1 && ladder[row][col - 1]) col--;
            }
            if (col != i) return false;
        }
        return true;
    }
}
