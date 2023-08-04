package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] coin = new Integer[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin, Collections.reverseOrder());

        int idx = 0;
        int cnt = 0;
        while (K > 0) {
            cnt += K / coin[idx];
            K %= coin[idx++];
        }
        System.out.print(cnt);
    }

}
