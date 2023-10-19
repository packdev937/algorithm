package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3184 {

    static char[][] board;
    static boolean[][] visited;
    static int wolf, sheep;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            int idx = 0;
            for (char c : chars) {
                board[i][idx++] = c;
                if (c == 'v') {
                    wolf++;
                }
                if (c == 'o') {
                    sheep++;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != '#' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheep+" "+wolf);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int wCnt = 0;
        int sCnt = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (visited[temp[0]][temp[1]]) {
                continue;
            }
            if (board[temp[0]][temp[1]] == 'v') {
                wCnt++;
            }

            if (board[temp[0]][temp[1]] == 'o') {
                sCnt++;
            }
            visited[temp[0]][temp[1]] = true;

            for (int k = 0; k < 4; k++) {
                int ny = dy[k] + temp[0];
                int nx = dx[k] + temp[1];

                if (nx >= 0 && ny >= 0 && nx < board[0].length && ny < board.length
                    && !visited[ny][nx] && board[ny][nx] != '#') {
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        if (sCnt > wCnt) {
            wolf -= wCnt;
        } else {
            sheep -= sCnt;
        }
    }

}
