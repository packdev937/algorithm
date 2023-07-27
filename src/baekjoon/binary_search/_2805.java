package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2805 {

    static int N, M;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        tree = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);
        int start = 0;
        int end = tree[tree.length - 1];
        int mid = Integer.MAX_VALUE;

        while (start < end) {
            mid = (start + end) / 2;

            if (calculateHeight(mid) >= M) {
                start = mid + 1;
            } else if (calculateHeight(mid) < M) {
                end = mid;
            }
        }

        System.out.println(start - 1);
    }

    //

    public static int calculateHeight(int mid) {
        int sum = 0;
        for (int i = 0; i < tree.length; i++) {
            sum += tree[i] - mid < 0 ? 0 : tree[i] - mid;
        }

        return sum;
    }
}