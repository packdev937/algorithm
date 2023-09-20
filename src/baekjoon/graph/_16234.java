package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16234 {

    static int[][] board;
    static boolean[][] ch;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int N, L, R;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while (true) {
            ch = new boolean[N][N];
            boolean isTrue = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (!ch[i][j]) {
                        List<int[]> list = new ArrayList<>();
                        int sum = bfs(i, j, list);
                        if (list.size() > 1) {
                            isTrue = true;
                            for (int[] temp : list) {
                                board[temp[0]][temp[1]] = sum / list.size();
                            }
                        }
                    }
                }
            }
            if (!isTrue) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }

    public static int bfs(int x, int y, List<int[]> list) {
        int sum = 0;
        queue.add(new int[]{x, y});
        ch[x][y] = true;
        list.add(new int[]{x, y});
        sum += board[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !ch[nx][ny]) {
                    int diff = Math.abs(board[current[0]][current[1]] - board[nx][ny]);
                    if (diff >= L && diff <= R) {
                        queue.add(new int[]{nx, ny});
                        ch[nx][ny] = true;
                        list.add(new int[]{nx, ny});
                        sum += board[nx][ny];
                    }
                }
            }
        }

        return sum;
    }
}
