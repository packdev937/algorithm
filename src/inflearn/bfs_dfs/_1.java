package inflearn.bfs_dfs;

import java.util.Scanner;

public class _1 {
    static boolean isTrue = false;

    public static void DFS(int[] arr, int idx, int total) {
        if (idx == arr.length) {
            if (total == 0) {
                isTrue = true;
                return;
            } else return;
        }
        DFS(arr, idx + 1, total + arr[idx]);
        DFS(arr, idx + 1, total - arr[idx]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(arr, 0, 0);
        if (isTrue) System.out.println("YES");
        else System.out.println("NO");
    }
}
