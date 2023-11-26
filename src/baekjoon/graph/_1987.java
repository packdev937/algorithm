package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1987 {

    static char[][] board;
    static int[] dy = {0, 1, 0, -1}, dx = {-1, 0, 1, 0};
    static int N, M, answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
	board[i][j] = input.charAt(j);
            }
        }
        boolean[] ch = new boolean[26];
        dfs(0, 0, ch, 1);
        System.out.println(answer);
    }

    public static void dfs(int i, int j, boolean[] ch, int cnt) {
        char c = board[i][j];
        int cIdx = c - 'A';
        ch[cIdx] = true;
        answer = Math.max(answer, cnt);
        for (int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];
            if (ny >= 0 && nx >= 0 && ny < N && nx < M && !ch[board[ny][nx] - 'A']) {
	dfs(ny, nx, ch, cnt + 1);
            }
        }
        // DFS 사용 시 주의해야할 점
        ch[cIdx] = false;
    }
}
