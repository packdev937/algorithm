package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = Integer.parseInt(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            sum += Integer.parseInt(br.readLine()) - 1;
        }
        System.out.println(sum);
    }
}
