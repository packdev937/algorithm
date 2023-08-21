package baekjoon.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15652 {

    static boolean[] ch;
    static int[] num;

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ch = new boolean[N + 1];
        num = new int[M];

        dfs(1, 0);
        System.out.println(sb);
    }

    public static void dfs(int j, int index) {
        if (index == M) {
            for (int i = 0; i < num.length; i++) {
                sb.append(num[i] + " ");
            }
            sb.append("\n");
            return;
        } else {
            for (int i = j; i <= N; i++) {
                if (ch[i]) {
                    continue;
                }
                num[index] = i;
                dfs(i, index + 1);
            }
        }
    }

}
