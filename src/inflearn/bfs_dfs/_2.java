package inflearn.bfs_dfs;

import java.util.Scanner;

public class _2 {
    public static int maxWeight = 0;
    public static int C, N;
    public static int[] arr;

    public static void DFS(int weight, int index) {
        if (weight > maxWeight && weight <= C) maxWeight = weight;
        if (index >= N) return;
        if (weight > C) return;

        DFS(weight + arr[index], index + 1);
        DFS(weight, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0, 0);
        System.out.println(maxWeight);
    }
}
