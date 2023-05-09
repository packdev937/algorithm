package baekjoon.data_structure;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class _3190 {
    static int[][] board;
    static HashMap<Integer, Character> map = new HashMap<>();
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // true 면 right, false면 left
        boolean Mode = true;

        //Board Initialization
        board = new int[N][N];

        // Number of Apples
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            board[a - 1][b - 1] = 1;
        }
        // Number of Rotation
        int L = sc.nextInt();
        for (int i = 0; i < L; i++) {
            int a = sc.nextInt();
            char c = sc.next().charAt(0);
            map.put(a, c);
        }

        while (true) {
            // 벽에 막히는 횟수
        }
    }
}

// https://www.acmicpc.net/problem/3190
