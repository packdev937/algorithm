package inflearn.bfs_dfs;

import java.util.Scanner;

public class _7 {
    static int[][] arr;

    public static int dfs(int n, int r) {
        if (arr[n][r] != 0 && r != -1 && n >= r) return arr[n][r];
        else if (n == r) return 1;
        else if (r == 0) return 1;
        else if (r == -1) return 0;
        else if (r > n) return 0;
        else {
            return arr[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        arr = new int[n + 1][r + 1];

        dfs(n, r);
        System.out.print(arr[n][r]);
    }
}
