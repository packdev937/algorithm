package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            long answer = 0;
            int max = 0;
            for (int j = N - 1; j >= 0; j--) {
	if (Integer.parseInt(input[j]) > max) {
	    max = Integer.parseInt(input[j]);
	} else {
	    answer += (max - Integer.parseInt(input[j]));
	}
            }
            System.out.println(answer);
        }
    }
}