package inflearn.bfs_dfs;

import java.util.Scanner;

public class _8 {
    static int N, R;
    static int[] P, B, ch;
    static int[][] arr;
    static boolean isFinish;

    public static void P(int l) {
        if (l == N && isFinish == false) {
            int sum = 0;
            for (int i = 0; i < P.length; i++) {
                sum += (P[i] + 1) * B[i];
            }
            if (sum == R) {
                for (int i = 0; i < P.length; i++) {
                    System.out.print((P[i] + 1) + " ");
                }
                isFinish = true;
            }
        }
        for (int i = 0; i < N; i++) {
            if (ch[i] == 0) {
                P[l] = i;
                ch[i] = 1;
                P(l + 1);
                ch[i] = 0;
            } else if (ch[i] != 0) continue;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        P = new int[N];
        B = new int[N];
        ch = new int[N];
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            B[i] = C(N - 1, i);
        }
        P(0);
    }

    public static int C(int n, int r) {
        if (arr[n][r] != 0 && r != -1 && n >= r) return arr[n][r];
        else if (n == r) return 1;
        else if (r == 0) return 1;
        else if (r == -1) return 0;
        else if (r > n) return 0;
        else {
            return arr[n][r] = C(n - 1, r - 1) + C(n - 1, r);
        }
    }
}
