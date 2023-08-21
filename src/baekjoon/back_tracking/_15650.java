package baekjoon.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650 {

    static boolean[] ch;
    static int[] num;

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ch = new boolean[N + 1];
        num = new int[M];

        dfs(1, 0);
    }

    public static void dfs(int j, int index) {
        if (index == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num.length; i++) {
                sb.append(num[i] + " ");
            }
            System.out.println(sb);
            return;
        } else {
            for (int i = j; i <= N; i++) {
                if (ch[i]) {
                    continue;
                }
                num[index] = i;
                ch[i] = true;
                dfs(i + 1, index + 1);
                ch[i] = false;
            }
        }
    }
}
