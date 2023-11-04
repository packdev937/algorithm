package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _4179 {

    static char[][] board;
    static int R, C;
    static Queue<int[]> playerQueue = new LinkedList<>();
    static Queue<int[]> fireQueue = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dy = {0, 1, 0, -1}, dx = {-1, 0, 1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(escapeMaze());
    }

    public static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'J') {
                    playerQueue.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (board[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j});
                }
            }
        }
    }

    public static String escapeMaze() {
        int time = 0;

        while (!playerQueue.isEmpty()) {
            time++;
            // Move fire
            int fireSize = fireQueue.size();
            for (int f = 0; f < fireSize; f++) {
                int[] fire = fireQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = fire[0] + dy[i];
                    int nx = fire[1] + dx[i];
                    if (isInBounds(ny, nx) && board[ny][nx] == '.') {
                        board[ny][nx] = 'F';
                        fireQueue.add(new int[]{ny, nx});
                    }
                }
            }

            // Move player
            int playerSize = playerQueue.size();
            for (int p = 0; p < playerSize; p++) {
                int[] player = playerQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = player[0] + dy[i];
                    int nx = player[1] + dx[i];
                    // If reaches the edge, escape successful
                    if (!isInBounds(ny, nx)) return String.valueOf(time);
                    if (!visited[ny][nx] && board[ny][nx] == '.') {
                        visited[ny][nx] = true;
                        playerQueue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }

    public static boolean isInBounds(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}
