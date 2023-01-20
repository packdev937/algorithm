package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _4 {
    static int[] fibo;

    public static int fibo(int n) {
        if(fibo[n]!=0)
            return fibo[n];
        if(n == 1)
            return fibo[1];
        else if(n == 2)
            return fibo[2];
        else {
            return fibo[n] = fibo(n-1) + fibo(n-2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fibo = new int[N+1];
        fibo[1] = 1;
        fibo[2] = 1;

        fibo(N);

        for(int i = 1; i<=N; i++){
            System.out.print(fibo[i] + " ");
        }

    }
}
