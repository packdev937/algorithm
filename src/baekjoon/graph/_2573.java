package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2573 {

    static int[][] board;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int separateCount = isSeperate();
            if (separateCount >= 2) {
                break;
            } else {
                if (isAllMelted()) {
                    year = 0;
                    break;
                }
                year++;
            }

            int[][] melting = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] != 0) {
                        queue.add(new int[]{i, j});
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int ny = temp[0] + dy[i];
                    int nx = temp[1] + dx[i];
                    if (nx >= 0 && ny >= 0 && nx < M && ny < N
                        && board[ny][nx] == 0) {
                        cnt++;
                    }
                }
                melting[temp[0]][temp[1]] = cnt;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    board[i][j] = board[i][j] - melting[i][j] < 0 ? 0 : board[i][j] - melting[i][j];
                }
            }
        }
        System.out.println(year);
    }

    public static int isSeperate() {
        int divideCount = 0;
        boolean[][] ch = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!ch[i][j] && board[i][j] != 0) {
                    queue.add(new int[]{i, j});
                    ch[i][j] = true;
                    divideCount++;
                    while (!queue.isEmpty()) {
                        int[] temp = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int ny = dy[k] + temp[0];
                            int nx = dx[k] + temp[1];
                            if (nx >= 0 && ny >= 0 && nx < M && ny < N
                                && !ch[ny][nx] && board[ny][nx] != 0) {
                                ch[ny][nx] = true;
                                queue.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
        }
        return divideCount;
    }

    public static boolean isAllMelted() {
        boolean isTrue = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    return false; // 수정된 부분
                }
            }
        }
        return isTrue;
    }
}
