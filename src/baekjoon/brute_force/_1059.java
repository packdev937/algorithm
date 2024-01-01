package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1059 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int[] set = new int[S];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < S; i++) {
            set[i] = Integer.parseInt(tokens[i]);
        }
        int N = Integer.parseInt(br.readLine());

        Arrays.sort(set); // Sort the set for binary search

        // Find the closest smaller and larger numbers in set
        int smaller = 0, larger = 1001;
        for (int num : set) {
            if (num < N) {
	smaller = num;
            } else if (num > N) {
	larger = num;
	break;
            }
        }

        // If N is in the set, print 0
        if (Arrays.binarySearch(set, N) >= 0) {
            System.out.println(0);
            return;
        }

        // Calculate the number of unlucky numbers
        int result = (N - smaller - 1) * (larger - N) + (larger - N - 1);
        System.out.println(result);
    }
}
