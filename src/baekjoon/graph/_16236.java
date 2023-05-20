package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _16236 {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int[][] board;
    static boolean[][] ch;
    static int LV;
    static int sharkX, sharkY;

    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            int compareDist = o1[2] - o2[2];
            if (compareDist != 0) {
                return compareDist;
            }

            int compareY = o1[0] - o2[0];
            if (compareY != 0) {
                return compareY;
            }

            return o1[1] - o2[1];
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Intialization
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        LV = 2;

        for (int i = 0; i < board.length; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
                if (Integer.parseInt(s[j]) == 9) {
                    sharkX = j;
                    sharkY = i;
                    board[i][j] = 0;
                }
            }
        }

        int totalCnt = 0;
        int fishCnt = 0;
        while (ValidateAvaliableFish()) {
            int[] fish = pq.poll();
            fishCnt++;
            totalCnt += fish[2];
            board[fish[0]][fish[1]] = 0;
            sharkY = fish[0];
            sharkX = fish[1];
            if (fishCnt == LV) {
                fishCnt = 0;
                LV++;
            }
            pq.clear();
        }
        System.out.println(totalCnt);
        br.close();
    }

    public static boolean ValidateAvaliableFish() {
        boolean isTrue = false;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sharkY, sharkX, 0});
        ch = new boolean[board.length][board[0].length];

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int Y = temp[0];
            int X = temp[1];
            int dist = temp[2];
            if (board[Y][X] != 0 && board[Y][X] < LV) {
                isTrue = true;
                pq.add(new int[]{Y, X, dist});
            }
            for (int i = 0; i < 4; i++) {
                int tempY = Y + dy[i];
                int tempX = X + dx[i];
                if (tempY < board.length && tempY >= 0 && tempX < board[0].length && tempX >= 0) {
                    if (ch[tempY][tempX] == false && board[tempY][tempX] <= LV) {
                        ch[tempY][tempX] = true;
                        q.add(new int[]{tempY, tempX, dist + 1});
                    }
                }
            }
        }
        return isTrue;
    }
}