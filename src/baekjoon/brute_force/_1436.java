package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int answer = 0;
        int num = 666;
        while (true) {
            if (String.valueOf(num).contains("666")) {
                answer = num;
                cnt++;
                num++;
            } else num++;

            if (cnt == N) {
                break;
            }
        }
        System.out.println(answer);
    }
}
