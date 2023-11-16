package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2512 {

    static int max, mid, limit;
    static int[] budget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        budget = new int[N];
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budget[i]);
        }
        limit = Integer.parseInt(br.readLine());
        int start = 0;
        int end = max;
        while (start <= end) {
            mid = (start + end) / 2;
            if (isPossible(mid)) {
	start = mid + 1;
            } else {
	end = mid - 1;
            }
        }

        System.out.println(end);
    }

    public static boolean isPossible(int value) {
        int sum = 0;
        for (int b : budget) {
            sum += Math.min(b, value);
        }
        return sum <= limit;
    }
}
