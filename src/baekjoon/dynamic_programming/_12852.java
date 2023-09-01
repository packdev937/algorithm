package baekjoon.dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class _12852 {

    static int[] dp;
    static int[] route;

    static int INF = 9999999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        dp = new int[N + 1];
        Arrays.fill(dp, INF);
        route = new int[N + 1];

        // Initialization
        dp[N] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return dp[o1] - dp[o2];
            }
        });

        queue.add(N);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp == 1) {
                break;
            }
            if (temp % 3 == 0) {
                if (dp[temp / 3] > dp[temp] + 1) {
                    dp[temp / 3] = dp[temp] + 1;
                    queue.add(temp / 3);
                    route[temp / 3] = temp;
                }
            }
            if (temp % 2 == 0) {
                if (dp[temp / 2] > dp[temp] + 1) {
                    dp[temp / 2] = dp[temp] + 1;
                    queue.add(temp / 2);
                    route[temp / 2] = temp;
                }
            }
            if (dp[temp - 1] > dp[temp] + 1) {
                dp[temp - 1] = dp[temp] + 1;
                queue.add(temp - 1);
                route[temp - 1] = temp;
            }
        }

        int a = 1;
        sb.append(a + " ");
        while (true) {
            if (a == N) {
                break;
            }
            sb.insert(0, route[a] + " ");
            a = route[a];
        }
        System.out.println(dp[1]);
        System.out.println(sb);
    }
}
