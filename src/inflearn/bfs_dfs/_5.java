package inflearn.bfs_dfs;

import java.util.Scanner;

public class _5 {
    public static int[] coin;
    public static int min = 999;

    public static void DFS(int remain, int cnt) {
        if (remain == 0 && min > cnt) {
            min = cnt;
        }
        if (cnt > min)
            return;
        if (remain < 0)
            return;

        for (int i = 0; i < coin.length; i++) {
            DFS(remain - coin[coin.length - 1 - i], cnt + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        coin = new int[N];
        for (int i = 0; i < coin.length; i++) {
            coin[i] = sc.nextInt();
        }
        int remain = sc.nextInt();
        DFS(remain, 0);

        System.out.println(min);
    }
}
