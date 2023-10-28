package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1303 {

    static boolean[][] visited;
    static char[][] board;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static long wCount = 0;
    static long bCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new char[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!visited[i][j]) {
                    bfs(board[i][j], i, j);
                }
            }
        }
        System.out.println(wCount + " " + bCount);
    }

    public static void bfs(char c, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (visited[temp[0]][temp[1]]) {
                continue;
            }
            visited[temp[0]][temp[1]] = true;
            cnt++;
            for (int k = 0; k < 4; k++) {
                int ny = temp[0] + dy[k];
                int nx = temp[1] + dx[k];
                if (ny >= 0 && nx >= 0 && ny < board.length && nx < board[0].length
                    && !visited[ny][nx] && board[ny][nx] == c) {
                    queue.add(new int[]{ny, nx});
                }
            }
        }
        if (c == 'B') {
            bCount += Math.pow(cnt, 2);
        } else {
            wCount += Math.pow(cnt, 2);
        }
    }
}

// 뭐가 틀린걸까?
// 범위를 잘 생각하자
// 문제를 잘 읽자 -> M 이 세로 N이 가로인데 거꾸로 입력 받았따