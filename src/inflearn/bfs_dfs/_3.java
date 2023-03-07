package inflearn.bfs_dfs;

import java.util.Scanner;

public class _3 {
    public static int M, N;
    public static int maxScore = 0;
    public static int[][] arr;

    public static void DFS(int score, int time, int index) {
        if (score > maxScore && time <= M) {
            maxScore = score;
        }
        if (time > M)
            return;
        if (index >= N)
            return;
        DFS(score + arr[index][0], time + arr[index][1], index + 1);
        DFS(score, time, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        DFS(0, 0, 0);
        System.out.println(maxScore);
    }
}
