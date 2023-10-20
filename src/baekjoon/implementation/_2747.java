package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2747 {
    private static final int FIBO_INDEX = 46;

    static int[] fibo = new int [FIBO_INDEX];

    public static int fibo(int n) {
        if (fibo[n] != 0) {
            return fibo[n];
        }
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        return fibo[n] = fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(fibo(num));
    }

}
