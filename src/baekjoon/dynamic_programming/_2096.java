package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2096 {

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (i == 0) {
                maxDp[0] = minDp[0] = A;
                maxDp[1] = minDp[1] = B;
                maxDp[2] = minDp[2] = C;
            } else {
                int maxDp0 = maxDp[0], maxDp2 = maxDp[2];
                maxDp[0] = Math.max(maxDp[0], maxDp[1]) + A;
                maxDp[2] = Math.max(maxDp[1], maxDp[2]) + C;
                maxDp[1] = Math.max(Math.max(maxDp0, maxDp[1]), maxDp2) + B;

                int minDp0 = minDp[0], minDp2 = minDp[2];
                minDp[0] = Math.min(minDp[0], minDp[1]) + A;
                minDp[2] = Math.min(minDp[1], minDp[2]) + C;
                minDp[1] = Math.min(Math.min(minDp0, minDp[1]), minDp2) + B;
            }
        }
        System.out.println(Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) + " " + Math.min(
            Math.min(minDp[0], minDp[1]), minDp[2]));
    }
}
