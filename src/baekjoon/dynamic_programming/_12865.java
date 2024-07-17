package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _12865 {

    static List<int[]> items;
    static int[] dp;
    static int N, K, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K + 1];
        items = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items.add(
	new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(items, (a, b) -> {
            if (a[1] / a[0] != b[1] / b[0]) {
	return b[1] / b[0] - a[1] / a[0];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < items.size(); i++) {
            recur(i, 0, items.get(i)[0], items.get(i)[1]);
        }

        System.out.println(max);
    }

    private static void recur(int index, int currentWeight, int weight, int value) {
        int targetWeight = currentWeight + weight;
        int newValue = dp[currentWeight] + value;

        if (targetWeight > K) {
            return;
        }

        if (newValue < dp[targetWeight]) {
            return;
        }

        max = Math.max(max, newValue);

        dp[targetWeight] = newValue;

        for (int i = index; i < items.size(); i++) {
            recur(i, targetWeight, items.get(i)[0], items.get(i)[1]);
        }
    }

}
