package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = 1001;
        int[] arr = new int[arraySize];
        int idx = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
	if (idx == arraySize) {
	    break;
	}
	arr[idx++] = i;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = A - 1; i < B; i++) {
            sum += arr[i];
        }

        System.out.print(sum);
    }

}
