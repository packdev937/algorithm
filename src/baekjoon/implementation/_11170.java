package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(countZeros(a, b));
        }
    }

    public static int countZeros(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            count += countZero(i);
        }

        return count;
    }

    public static int countZero(int n) {
        int count = 0;
        if (n == 0) {
            return 1;
        }

        while (n > 0) {
            if (n % 10 == 0) {
	count++;
            }
            n /= 10;
        }
        return count;
    }


}
