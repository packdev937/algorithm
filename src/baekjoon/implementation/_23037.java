package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int sum = 0;

        for (char c : number.toCharArray()) {
            int n = c - '0';
            int result = (int) Math.pow(n, 5);
            sum += result;
        }

        System.out.println(sum);
    }

}
