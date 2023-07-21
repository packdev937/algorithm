package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1267 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = 0, Y = 0;
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            Y += ((Integer.parseInt(arr[i]) / 30) + 1) * 10;
            M += ((Integer.parseInt(arr[i]) / 60) + 1) * 15;
        }
        System.out.print(Y == M ? "Y M " + Y : Y < M ? "Y " + Y : "M " + M);
    }

}
