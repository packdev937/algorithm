package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2638 {

    static int[][] board;
    static boolean ch[][];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        ch = new boolean[N][M];

        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while (true) {
            air();
            if (isMelted()) {
                break;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1) {
                        queue.add(new int[]{i, j});
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int count = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = temp[0] + dx[i];
                    int ny = temp[1] + dy[i];

                    if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length
                        && board[nx][ny] == 9) {
                        count++;
                    }
                }
                if (count >= 2) {
                    board[temp[0]][temp[1]] = 0;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isMelted() {
        boolean isTrue = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 9) {
                    isTrue = false;
                    break;
                }
            }
        }
        return isTrue;
    }

    public static void air() {
        ch = new boolean[board.length][board[0].length];
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            board[temp[0]][temp[1]] = 9;
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length
                    && (board[nx][ny] == 0 || board[nx][ny] == 9) && !ch[nx][ny]) {
                    ch[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}