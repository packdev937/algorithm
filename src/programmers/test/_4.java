package programmers.test;

import java.util.*;

public class _4 {
    static boolean isGameOver = false;
    int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};

    public String[] solution(String[] board, int y, int x) {
        int n = board.length, m = board[0].length();
        boolean[][] ch = new boolean[n][m];
        char[][] charBoard = new char[n][m];

        for (int i = 0; i < board.length; i++) {
            charBoard[i] = board[i].toCharArray();
        }

        dfs(charBoard, ch, y, x);
        if (!isGameOver)
            blineMines(charBoard, ch);
        String[] result = new String[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(charBoard[i]);
        }
        return result;
    }

    public void dfs(char[][] board, boolean[][] ch, int y, int x) {
        // 맵을 벗어나는 경우 종료
        if (y < 0 || x < 0 || y >= board.length || x >= board[0].length || ch[y][x] == true)
            return;

        ch[y][x] = true;

        // 만약 지뢰인 경우
        if (board[y][x] == 'M') {
            board[y][x] = 'X';
            return;
        }

        int mines = countMines(board, y, x);
        if (mines > 0) {
            isGameOver = true;
            board[y][x] = (char) (mines + '0');
            return;
        }

        board[y][x] = 'B';
        for (int i = 0; i < 8; i++) {
            dfs(board, ch, y + dy[i], x + dx[i]);
        }
    }

    public int countMines(char[][] board, int y, int x) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int ty = y + dy[i];
            int tx = x + dx[i];
            if (ty >= 0 && ty < board.length && tx >= 0 && tx < board[0].length && board[ty][tx] == 'M')
                cnt++;
        }
        return cnt;
    }

    public void blineMines(char[][] board, boolean[][] ch) {
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if (!ch[i][j])
                    board[i][j] = 'E';
            }
        }
    }

    public static void main(String[] args) {
        _4 T = new _4();
        String[] result = T.solution(new String[]{"EEEEE", "EEMEE", "EEEEE", "EEEEE"}, 2, 0);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length(); j++) {
                System.out.print(result[i].charAt(j));
            }
            System.out.println();
        }
    }
}
