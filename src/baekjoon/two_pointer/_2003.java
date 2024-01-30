package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lp = 0, rp = 0;
        int sum = 0, count = 0;
        while (true) {
            if (rp == arr.length) {
	break;
            }
            if (sum < M) {
	sum += arr[rp++];
            }

            while (sum > M) { // 틀린 부분
	sum -= arr[lp++];
            }

            if (sum == M) {
	count++;
	sum -= arr[lp++];
            }
        }
        System.out.print(count);
    }

}
