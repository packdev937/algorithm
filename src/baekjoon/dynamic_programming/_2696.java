package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _2696 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer>[] dp = new HashSet[N];
        int[] weights = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = new HashSet<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] inputs = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        // Initialization
        dp[0].add(weights[0]);
        dp[0].add(0);
        for (int i = 1; i < N; i++) {
            Iterator<Integer> iter = dp[i - 1].iterator();
            while (iter.hasNext()) {
                int n = iter.next();
                dp[i].add(n);
                dp[i].add(weights[i] + n);
                dp[i].add(Math.abs(weights[i] - n));
            }
        }

        for (int i = 0; i < M; i++) {
            if (dp[dp.length - 1].contains(inputs[i])) {
                System.out.print("Y" + " ");
            } else {
                System.out.print("N" + " ");
            }
        }

    }
}

// 1 0
// 1 0 5 4