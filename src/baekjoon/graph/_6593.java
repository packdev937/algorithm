package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6593 {

    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 0, 1, 0, -1};
    static int[] dx = {0, 0, -1, 0, 1, 0};
    static int L, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            int[] startPoint = new int[1];
            char[][][] board = new char[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String input = br.readLine();
                    for (int k = 0; k < C; k++) {
                        board[i][j][k] = input.charAt(k);
                        if (input.charAt(k) == 'S') {
                            startPoint = new int[]{i, j, k};
                        }
                    }
                }
                if (i < L) {
                    br.readLine(); // 각 층 사이의 빈 줄 읽기
                }
            }
            int num = bfs(startPoint, board);
            if (num == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).\n", num);
            }
        }
    }

    private static int bfs(int[] startPoint, char[][][] board) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[L][R][C];
        queue.add(new int[]{startPoint[0], startPoint[1], startPoint[2], 0});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (board[temp[0]][temp[1]][temp[2]] == 'E') {
                return temp[3];
            }
            if (visited[temp[0]][temp[1]][temp[2]]) {
                continue;
            }
            visited[temp[0]][temp[1]][temp[2]] = true;
            for (int i = 0; i < 6; i++) {
                int nz = temp[0] + dz[i];
                int ny = temp[1] + dy[i];
                int nx = temp[2] + dx[i];
                if (nz >= 0 && ny >= 0 && nx >= 0 && nz < L && ny < R && nx < C
                    && board[nz][ny][nx] != '#' && !visited[nz][ny][nx]) {
                    queue.add(new int[]{nz, ny, nx, temp[3] + 1});
                }
            }
        }
        return -1;
    }

}
