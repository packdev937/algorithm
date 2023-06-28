package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1743 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] board;
    static boolean[][] ch;

    static Queue<int[]> q = new LinkedList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로 길이
        int N = Integer.parseInt(st.nextToken());
        // 가로 길이
        int M = Integer.parseInt(st.nextToken());
        // 음식물 쓰레기 개수
        int K = Integer.parseInt(st.nextToken());

        // Initialization
        board = new int[N][M];
        ch = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            board[j - 1][l - 1] = 1;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    q.add(new int[]{i, j});
                    int cnt = 0;

                    while (!q.isEmpty()) {
                        int[] temp = q.poll();
                        int x = temp[0];
                        int y = temp[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                                if (board[nx][ny] == 1 && !ch[nx][ny]) {
                                    q.add(new int[]{nx, ny});
                                    ch[nx][ny] = true;
                                    cnt++;
                                }
                            }
                        }
                        max = Math.max(max, cnt);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
