package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2303 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxIndex = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            String[] numbers = br.readLine().split(" ");
            int currentMax = 0;

            for (int j = 0; j < 3; j++) {
	for (int k = j + 1; k < 4; k++) {
	    for (int l = k + 1; l < 5; l++) {
	        int number = Integer.parseInt(numbers[j]) + Integer.parseInt(numbers[k])
	            + Integer.parseInt(numbers[l]);
	        currentMax = Math.max(currentMax, number % 10);
	    }
	}
            }

            if (currentMax >= max) {
	max = currentMax;
	maxIndex = i + 1;
            }
        }

        System.out.println(maxIndex);
    }

}
