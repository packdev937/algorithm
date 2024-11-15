package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 2 * N; i++) {
            for(int j = 0; j < Math.abs(N-i); j++) {
                System.out.print(" ");
            }

            for(int j = 0; j < 2 * N - 1 - 2 * Math.abs(N-i); j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
