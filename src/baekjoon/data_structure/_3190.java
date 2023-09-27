package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _3190 {

    static int[][] board;
    static HashMap<Integer, Character> map = new HashMap<>();
    static Deque<int[]> snake = new ArrayDeque<>();
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int direction = 0;

        board = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a - 1][b - 1] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            map.put(a, c);
        }

        snake.add(new int[]{0, 0});
        board[0][0] = 2;

        int cnt = 0;
        while (true) {

            if (map.containsKey(cnt)) {
                direction = map.get(cnt) == 'D' ? (direction + 1) % 4 : (direction + 3) % 4;
            }
            cnt++;

            int[] current = snake.peekFirst();
            int ny = current[0] + directions[direction][0];
            int nx = current[1] + directions[direction][1];

            if (isCrush(ny, nx)) {
                break;
            }

            if (isApple(ny, nx)) {
                board[ny][nx] = 2;
                snake.addFirst(new int[]{ny, nx}); // 사과를 먹으면 머리만 이동
            } else {
                board[ny][nx] = 2;
                snake.addFirst(new int[]{ny, nx});
                int[] remove = snake.pollLast();
                board[remove[0]][remove[1]] = 0; // 사과를 먹지 않으면 머리와 꼬리 모두 이동
            }
        }
        System.out.print(cnt);
    }

    static boolean isCrush(int y, int x) {
        return y < 0 || x < 0 || y >= board.length || x >= board.length || board[y][x] == 2;
    }

    static boolean isApple(int y, int x) {
        if (board[y][x] == 1) {
            board[y][x] = 0;
            return true;
        }
        return false;
    }
}
