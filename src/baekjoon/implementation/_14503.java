package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 14503 골드5 로봇 청소기
public class _14503 {

    static int N, M, d, r, c;
    static int[][] board;
    static boolean[][] ch;
    static int answer;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        ch = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        // 0은 위로 한칸, 1는 오른쪽으로 한칸, 2는 밑으로 한칸, 3은 왼쪽으로 한칸
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (!ch[r][c]) {
                answer++;
                ch[r][c] = true;
            }
            if (checkToClean()) {
                somethingToClean();
            } else {
                if (!nothingToClean()) {
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean checkToClean() {
        for (int i = 0; i < 4; i++) {
            int ny = r + dy[i];
            int nx = c + dx[i];
            if (ny >= 0 && nx >= 0 && ny < N && nx < M && !ch[ny][nx] && board[ny][nx] != 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean nothingToClean() {
        switch (d) {
            case 0:
                if (r + 1 > N || board[r + 1][c] == 1) {
                    return false;
                }
                r++;
                return true;
            case 1:
                if (c - 1 < 0 || board[r][c - 1] == 1) {
                    return false;
                }
                c--;
                return true;
            case 2:
                if (r - 1 < 0 || board[r - 1][c] == 1) {
                    return false;
                }
                r--;
                return true;
            case 3:
                if (c + 1 > M || board[r][c + 1] == 1) {
                    return false;
                }
                c++;
                return true;
            default:
                return false;
        }
    }

    public static void somethingToClean() {
        d = (d + 3) % 4;

        int nextX = c + dx[d];
        int nextY = r + dy[d];

        if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && board[nextY][nextX] != 1
            && !ch[nextY][nextX]) {
            c = nextX;
            r = nextY;
        }
    }
}

// ch[nx][ny] 가 아닌 ch[ny][nx]
// d = (d+1) % 4;