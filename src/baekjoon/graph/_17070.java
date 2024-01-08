package baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _17070 {

    static int N;
    static int[][] board;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
	board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        DFS(1, 2, 0);

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int x, int y, int direction) {
        if (x == N && y == N) {
            count++;
            return;
        }

        switch (direction) {
            case 0:
	if (y + 1 <= N && board[x][y + 1] == 0) { // 동쪽
	    DFS(x, y + 1, 0);
	}
	break;
            case 1:
	if (x + 1 <= N && board[x + 1][y] == 0) { // 남쪽
	    DFS(x + 1, y, 1);
	}
	break;
            case 2:
	if (y + 1 <= N && board[x][y + 1] == 0) { // 동쪽
	    DFS(x, y + 1, 0);
	}

	if (x + 1 <= N && board[x + 1][y] == 0) { // 남쪽
	    DFS(x + 1, y, 1);
	}
	break;
        }

        if (y + 1 <= N && x + 1 <= N && board[x][y + 1] == 0 && board[x + 1][y] == 0
            && board[x + 1][y + 1] == 0) {
            DFS(x + 1, y + 1, 2);
        }
    }

}