package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class _1107 {

    static boolean broken[] = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int answer = Math.abs(N - 100); // 현재 100번 채널에서 +,-로만 이동하는 경우

        for (int i = 0; i <= 1000000; i++) {
            int len = possible(i);
            if (len > 0) {
                int press = Math.abs(i - N);
                answer = Math.min(answer, len + press);
            }
        }

        System.out.println(answer);
    }

    public static int possible(int num) {
        if (num == 0) {
            return broken[0] ? 0 : 1;
        }

        int len = 0;

        while (num > 0) {
            if (broken[num % 10]) {
                return 0;
            }
            len++;
            num /= 10;
        }

        return len;
    }
}
