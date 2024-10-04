package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5800 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            for (int j = 0; j < arr.length; j++) {
	arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int largestGap = Integer.MIN_VALUE;
            for (int j = 0; j < arr.length-1; j++) {
	largestGap = Math.max(largestGap, arr[j+1] - arr[j]);
            }

            System.out.println("Class " + (i+1));
            System.out.printf("Max %d, Min %d, Largest gap %d\n", arr[N-1], arr[0], largestGap);
        }
    }

}
