package baekjoon.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _5014 {

    static Queue<int[]> queue = new LinkedList<>();
    static int F, S, G, U, D;
    static int[] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        count = new int[F + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[S] = 0;
        queue.add(new int[]{S, 0});
        bfs();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[0] == G) {
                System.out.println(count[G]);
                return;
            }
            for (int i = 0; i < 2; i++) {
                int nextFloor = temp[0] + (i == 0 ? U : -D);
                // 만약 가려고 하는 층수의 count가 더 작다면, 현재 시도는 제외 (이렇게 queue를 점점 줄여나감)
                if (nextFloor >= 1 && nextFloor <= F && count[nextFloor] > temp[1] + 1) {
                    count[nextFloor] = temp[1] + 1;
                    queue.add(new int[]{nextFloor, count[nextFloor]});
                }
            }
        }
        System.out.println("use the stairs");
    }
}
