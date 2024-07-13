package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2960 {

    static int[] arr = new int[1001];
    static final int MARKED = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Arrays.fill(arr, 1);

        int start = 2;
        while (true) {
            if (isEmpty(N)) {
	N *= 2;
            }
            for (int i = start; i <= N; i += start) {
	if (arr[i] != MARKED) {
	    arr[i] = MARKED;
	    K--;
	    if (K == 0) {
	        System.out.print(i);
	        return;
	    }
	}
            }
            start++;
        }
    }

    private static boolean isEmpty(int N) {
        for (int i = 2; i < N; i++) {
            if (arr[i] == 1) {
	return false;
            }
        }
        return true;
    }
}

// 2 3 4 5 6 7
// 2 4 6 => 3